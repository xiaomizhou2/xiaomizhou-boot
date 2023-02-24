package com.xiaomizhou.springmvc.configuration;

import com.xiaomizhou.common.vo.Query;
import com.xiaomizhou.springmvc.resolver.DefaultQueryParametersArgumentResolver;
import com.xiaomizhou.springmvc.resolver.QueryParametersArgumentResolver;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.MethodParameter;
import org.springframework.web.method.annotation.MapMethodProcessor;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xiaomizhou
 * @date 2023/2/22
 * @email 521jx123@gmail.com
 */
@Configuration
public class QueryParametersArgumentResolverConfiguration implements WebMvcConfigurer {

    @Resource
    private SpringDataWebProperties springDataWebProperties;

    @Bean
    public QueryParametersArgumentResolver queryParametersArgumentResolver() {
        DefaultQueryParametersArgumentResolver resolver = new DefaultQueryParametersArgumentResolver();
        resolver.setPageParameterName(springDataWebProperties.getPageable().getPageParameter());
        resolver.setSizeParameterName(springDataWebProperties.getPageable().getSizeParameter());
        return resolver;
    }

    /**
     * 添加方法参数解析器
     *
     * @param argumentResolvers 方法参数解析器列表
     */
    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
        argumentResolvers.add(queryParametersArgumentResolver());
    }


    /**
     * 定制查询参数解析器配置的声明，重新定理了MapMethodProcessor，解决与MapMethodProcessor的问题
     */
    @Configuration
    @AutoConfigureAfter(WebMvcAutoConfiguration.class)
    public static class CustomArgumentResolversConfiguration implements InitializingBean {
        @Resource
        private RequestMappingHandlerAdapter requestMappingHandlerAdapter;

        /**
         * 重新定义MapMethodProcessor的处理，
         * 排除MapMethodProcessor对QueryParameters类型的支持
         */
        @Override
        public void afterPropertiesSet() {
            List<HandlerMethodArgumentResolver> argumentResolvers = requestMappingHandlerAdapter.getArgumentResolvers();
            List<HandlerMethodArgumentResolver> modifyArgumentResolvers = new ArrayList<>();

            if (argumentResolvers != null) {
                for (HandlerMethodArgumentResolver resolver : argumentResolvers) {
                    if (resolver instanceof MapMethodProcessor) {
                        modifyArgumentResolvers.add(new MapMethodProcessor() {
                            @Override
                            public boolean supportsParameter(MethodParameter parameter) {
                                return super.supportsParameter(parameter)
                                        && !Query.class.isAssignableFrom(parameter.getParameterType());
                            }
                        });
                    } else {
                        modifyArgumentResolvers.add(resolver);
                    }
                }
                requestMappingHandlerAdapter.setArgumentResolvers(modifyArgumentResolvers);
            }
        }
    }
}
