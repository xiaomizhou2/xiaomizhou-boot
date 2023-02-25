package com.xiaomizhou.mybatis.repository;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * @author xiaomizhou
 * @date 2023/2/25
 * @email 521jx123@gmail.com
 */
public interface BaseSearchRepository<T, ID> extends BaseMapper<T> {

    /**
     * 分页查询
     *
     * @param parameters
     * @param pageable
     * @return 查询列表
     */
    List<T> find(@Param("parameters") Map<String, Object> parameters, @Param("pageable") Pageable pageable);

    /**
     * 根据ID查询
     *
     * @param id
     * @return 查询实体
     */
    Optional<T> findById(ID id);

}
