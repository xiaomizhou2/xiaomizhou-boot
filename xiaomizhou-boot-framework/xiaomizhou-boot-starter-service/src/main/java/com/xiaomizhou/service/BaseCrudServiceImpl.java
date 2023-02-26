package com.xiaomizhou.service;

import com.xiaomizhou.common.entity.BasePersistableEntity;
import com.xiaomizhou.common.exception.BusinessException;
import com.xiaomizhou.common.exception.NotFoundException;
import com.xiaomizhou.mybatis.repository.BaseSearchRepository;
import com.xiaomizhou.mybatis.utils.MybatisPageHelper;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Auditable;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

/**
 * @author xiaomizhou
 * @date 2023/2/26
 * @email 521jx123@gmail.com
 */
@Slf4j
public abstract class BaseCrudServiceImpl<T, ID> implements BaseCrudService<T, ID> {
    @Resource
    protected MybatisPageHelper mybatisPageHelper;

    /**
     * 获取业务持久层对象
     *
     * @return 持久层对象
     */
    protected abstract BaseSearchRepository<T, ID> getRepository();

    /**
     * 获取审计用户
     *
     * @return 审计用户
     */
    protected abstract AuditorAware getAuditorAware();

    @Override
    public Page<T> find(Map<String, Object> query, Pageable pageable) {
        try {
            if (pageable != null) {
                mybatisPageHelper.startPage(pageable);
            }
            List<T> list = this.getRepository().find(query, pageable);
            return mybatisPageHelper.buildResult((com.github.pagehelper.Page) list, pageable);
        } catch (Exception e) {
            LOGGER.error("查询失败", e);
            throw new BusinessException("查询失败", e);
        }
    }

    @Override
    public List<T> findAll(Map<String, Object> query) {
        try {
            return this.getRepository().find(query, null);
        } catch (Exception e) {
            LOGGER.error("查询失败", e);
            throw new BusinessException("查询失败", e);
        }
    }

    @Override
    public T findById(ID id) {
        try {
            return this.getRepository().findById(id).orElseThrow(() -> new NotFoundException("数据不存在"));
        } catch (NotFoundException e) {
            LOGGER.error("数据不存在", e);
            throw new BusinessException("数据不存在", e);
        } catch (Exception e) {
            LOGGER.error("查询失败", e);
            throw new BusinessException("查询失败", e);
        }
    }

    @Override
    public void create(T entity) {
        try {
            if (entity instanceof BasePersistableEntity persistable) {
                if (persistable.isNew()) {
                    persistable.setId(UUID.randomUUID().toString().replaceAll("-", ""));
                }
            }
            this.auditableCreated(entity);
            this.getRepository().insert(entity);
        } catch (BusinessException e) {
            throw e;
        } catch (Exception e) {
            LOGGER.error("创建实体失败", e);
            throw new BusinessException("创建实体失败", e);
        }
    }

    @Override
    public void batchCreate(List<T> list) {
        for (T entity : list) {
            this.create(entity);
        }
    }

    @Override
    public void update(T entity) {
        try {
            auditableLastModify(entity);
            this.getRepository().updateById(entity);
        } catch (BusinessException e) {
            throw e;
        } catch (Exception e) {
            LOGGER.error("更新失败", e);
            throw new BusinessException("更新失败", e);
        }
    }

    @Override
    public void delete(ID id) {
        try {
            this.getRepository().deleteById((Serializable) id);
        } catch (BusinessException e) {
            throw e;
        } catch (Exception e) {
            LOGGER.error("删除失败", e);
            throw new BusinessException("删除失败", e);
        }
    }

    @Override
    public void batchDelete(List<ID> ids) {
        for (ID id : ids) {
            this.delete(id);
        }
    }

    /**
     * 创建增加审计信息
     *
     * @param entity
     */
    protected void auditableCreated(T entity) {
        if (entity instanceof Auditable auditable) {
            auditable.setCreatedDate(LocalDateTime.now());
            auditable.setLastModifiedDate(LocalDateTime.now());

            if (!auditable.getCreatedBy().isPresent()) {
                try {
                    Optional currentAuditor = getAuditorAware().getCurrentAuditor();
                    if (currentAuditor.isPresent()) {
                        auditable.setCreatedBy(currentAuditor.get());
                        auditable.setLastModifiedBy(currentAuditor.get());
                    }
                } catch (Exception e) {
                    LOGGER.warn("警告：不能获取当前用户，无法记录审计信息");
                }
            }
        }
    }

    /**
     * 更新增加审计信息
     *
     * @param entity
     */
    protected void auditableLastModify(T entity) {
        if (entity instanceof Auditable auditable) {
            auditable.setLastModifiedDate(LocalDateTime.now());
            try {
                Optional currentAuditor = getAuditorAware().getCurrentAuditor();
                if (currentAuditor.isPresent()) {
                    auditable.setLastModifiedBy(currentAuditor.get());
                }

            } catch (Exception e) {
                LOGGER.warn("警告：不能获取当前用户，无法记录审计信息");
            }
        }
    }
}
