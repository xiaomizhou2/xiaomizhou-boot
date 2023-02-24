package com.xiaomizhou.mybatis.utils;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * 分页插件接口
 *
 * @author xiaomizhou
 * @date 2023/2/22
 * @email 521jx123@gmail.com
 */
public interface MybatisPageHelper {

    /**
     * 执行分页
     *
     * @param pageable 分页对象
     */
    void startPage(Pageable pageable);

    /**
     * 将 PageHelper 分页查询结果封装成 spring-data 中的 Page 对象
     * @param page      PageHelper分页数据
     * @param pageable  分页对象
     * @return          spring-data 的 Page对象
     */
    Page buildResult(com.github.pagehelper.Page page, Pageable pageable);

}
