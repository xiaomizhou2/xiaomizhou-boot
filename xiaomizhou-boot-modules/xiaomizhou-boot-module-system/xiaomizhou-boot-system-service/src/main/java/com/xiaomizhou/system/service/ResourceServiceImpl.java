package com.xiaomizhou.system.service;

import com.xiaomizhou.service.BaseCrudServiceImpl;
import com.xiaomizhou.system.entity.ResourceEntity;
import com.xiaomizhou.system.entity.UserEntity;
import com.xiaomizhou.system.repository.ResourceRepository;
import jakarta.annotation.Resource;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.AuditorAware;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author xiaomizhou
 * @date 2023/2/26
 * @email 521jx123@gmail.com
 */
@Data
@Slf4j
@Transactional(rollbackFor = {RuntimeException.class})
@EqualsAndHashCode(callSuper = false)
public class ResourceServiceImpl extends BaseCrudServiceImpl<ResourceEntity, String> implements ResourceService {
    @Resource
    private ResourceRepository repository;
    @Resource
    private AuditorAware<UserEntity> auditorAware;

}
