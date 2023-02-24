package com.xiaomizhou.mybatis.configuration;

import com.xiaomizhou.mybatis.utils.DefaultMyBatisPageHelper;
import com.xiaomizhou.mybatis.utils.MybatisPageHelper;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author xiaomizhou
 * @date 2023/2/22
 * @email 521jx123@gmail.com
 */
@Configuration
public class MybatisPageHelperConfiguration {

    /**
     * 分页插件
     *
     * @return MybatisPageHelper
     */
    @Bean
    public MybatisPageHelper mybatisPageHelper() {
        return new DefaultMyBatisPageHelper();
    }
}
