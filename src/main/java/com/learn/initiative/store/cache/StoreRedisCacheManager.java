package com.learn.initiative.store.cache;

import lombok.AllArgsConstructor;
import org.checkerframework.framework.qual.PostconditionAnnotation;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

//@Component
@AllArgsConstructor
public class StoreRedisCacheManager {

    private final RedisCacheManager redisCacheManager;



    @PostConstruct
    public void init() {
        redisCacheManager.getCacheConfigurations();
    }

}
