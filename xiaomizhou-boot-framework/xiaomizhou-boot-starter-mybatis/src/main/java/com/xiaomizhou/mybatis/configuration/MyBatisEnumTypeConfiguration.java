package com.xiaomizhou.mybatis.configuration;

import com.xiaomizhou.mybatis.handler.AutoEnumTypeHandler;
import org.mybatis.spring.boot.autoconfigure.ConfigurationCustomizer;
import org.mybatis.spring.boot.autoconfigure.MybatisProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author xiaomizhou
 * @date 2023/2/22
 * @email 521jx123@gmail.com
 */
@Configuration
public class MyBatisEnumTypeConfiguration {

    @Bean
    ConfigurationCustomizer defaultEnumTypeHandlerConfigurationCustomizer() {
        return configuration -> {
            configuration.setDefaultEnumTypeHandler(AutoEnumTypeHandler.class);
        };
    }
}
