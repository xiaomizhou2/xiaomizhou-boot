package com.xiaomizhou.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Map;

/**
 * @author xiaomizhou
 * @date 2023/2/26
 * @email 521jx123@gmail.com
 */
public interface BaseCrudService<T, ID> {

    /**
     * 分页查询
     *
     * @param query     查询参数
     * @param pageable  分页参数
     * @return          查询结果
     */
    Page<T> find(Map<String, Object> query, Pageable pageable);

    /**
     * 查询列表
     *
     * @param query 查询参数
     * @return 查询结果
     */
    List<T> findAll(Map<String, Object> query);

    /**
     * 根据ID加载实体
     *
     * @param id ID
     * @return  查询实体
     */
    T findById(ID id);

    /**
     * 创建实体
     *
     * @param entity
     */
    void create(T entity);

    /**
     * 批量创建
     *
     * @param list
     */
    void batchCreate(List<T> list);

    /**
     * 更新
     *
     * @param entity
     */
    void update(T entity);

    /**
     * 删除
     *
     * @param id
     */
    void delete(ID id);

    /**
     * 批量删除
     *
     * @param ids
     */
    void batchDelete(List<ID> ids);
}
