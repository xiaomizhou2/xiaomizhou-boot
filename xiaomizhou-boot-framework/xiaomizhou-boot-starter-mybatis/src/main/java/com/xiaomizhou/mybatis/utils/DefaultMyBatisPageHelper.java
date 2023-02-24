package com.xiaomizhou.mybatis.utils;

import com.github.pagehelper.PageHelper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

/**
 * 默认的分页插件实现
 *
 * @author xiaomizhou
 * @date 2023/2/22
 * @email 521jx123@gmail.com
 */
public class DefaultMyBatisPageHelper implements MybatisPageHelper {
    @Override
    public void startPage(Pageable pageable) {
        PageHelper.startPage(pageable.getPageNumber() + 1, pageable.getPageSize());
    }

    @Override
    public Page buildResult(com.github.pagehelper.Page page, Pageable pageable) {
        return new PageImpl(page, pageable, page.getTotal());
    }
}
