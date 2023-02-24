package com.xiaomizhou.springmvc.resolver;

import com.xiaomizhou.common.vo.Query;
import jakarta.servlet.ServletRequest;
import lombok.Setter;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.ModelAndViewContainer;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

/**
 * @author xiaomizhou
 * @date 2023/2/22
 * @email 521jx123@gmail.com
 */
@Setter
public class DefaultQueryParametersArgumentResolver implements QueryParametersArgumentResolver {

    public static final String DEFAULT_PAGE_PARAMETER = "page";
    public static final String DEFAULT_SIZE_PARAMETER = "size";
    private String pageParameterName = DEFAULT_PAGE_PARAMETER;
    private String sizeParameterName = DEFAULT_SIZE_PARAMETER;

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return Query.class.equals(parameter.getParameter());
    }

    @Override
    public Query resolveArgument(MethodParameter parameter,
                                 ModelAndViewContainer mavContainer,
                                 NativeWebRequest webRequest,
                                 WebDataBinderFactory binderFactory) {
        ServletRequest request = (ServletRequest) webRequest.getNativeRequest();
        return new Query(getParameter(request));
    }

    private Map<String, Object> getParameter(ServletRequest request) {
        if (request == null) {
            return new HashMap<>();
        }

        Enumeration<String> parameterNames = request.getParameterNames();
        Map<String, Object> map = new HashMap<>();

        while (parameterNames != null && parameterNames.hasMoreElements()) {
            String name = parameterNames.nextElement();
            if (name.equals(pageParameterName) || name.equals(sizeParameterName)) {
                continue;
            }

            String[] values = request.getParameterValues(name);
            if (values != null && values.length == 1) {
                map.put(name, values[0]);
            }else {
                map.put(name, values);
            }
        }

        return map;
    }
}
