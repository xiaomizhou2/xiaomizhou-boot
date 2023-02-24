package com.xiaomizhou.springmvc.configuration;

import com.xiaomizhou.springmvc.exception.MvcGlobalExceptionHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author xiaomizhou
 * @date 2023/2/22
 * @email 521jx123@gmail.com
 */
@Configuration
public class SpringMvcGlobalExceptionConfiguration {

    /**
     * 全局异常处理配置类
     *
     * @return
     */
    @Bean
    public MvcGlobalExceptionHandler mvcGlobalExceptionHandler() {
        return new MvcGlobalExceptionHandler();
    }
}
