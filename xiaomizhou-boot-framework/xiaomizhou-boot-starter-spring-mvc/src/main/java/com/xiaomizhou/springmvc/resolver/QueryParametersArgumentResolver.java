package com.xiaomizhou.springmvc.resolver;

import com.xiaomizhou.common.exception.BusinessException;
import com.xiaomizhou.common.vo.Query;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

/**
 * @author xiaomizhou
 * @date 2023/2/22
 * @email 521jx123@gmail.com
 */
public interface QueryParametersArgumentResolver extends HandlerMethodArgumentResolver {

    @Override
    Query resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest,
                          WebDataBinderFactory binderFactory) throws BusinessException;
}
