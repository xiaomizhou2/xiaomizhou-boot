package com.xiaomizhou.common.vo;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;


/**
 * @author xiaomizhou
 * @date 2023/2/20 21:25
 * @email 521jx123@gmail.com
 */
public class Query extends LinkedHashMap<String, Object> {
    public Query() {
        super();
    }

    public Query(Map<? extends String, ?> map) {
        super(map);
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private final Map<String, Object> parameters = new HashMap<>();

        public Builder with(String key, Object value) {
            parameters.put(key, value);
            return this;
        }

        public Builder with(Map<String, Object> map) {
            parameters.putAll(map);
            return this;
        }

        public Query build() {
            return new Query(parameters);
        }
    }
}
