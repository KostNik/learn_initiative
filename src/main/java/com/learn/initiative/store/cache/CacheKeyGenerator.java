package com.learn.initiative.store.cache;

import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.lang.reflect.Method;

@Component
public class CacheKeyGenerator implements KeyGenerator {

    @Override
    public Object generate(Object target, Method method, Object... params) {
        return target.getClass().getSimpleName() + "_"
                + method.getName() + "_"
                + StringUtils.arrayToDelimitedString(params, "_");
    }
}
