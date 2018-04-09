package com.gobear.ignite.service.impl;

import com.gobear.ignite.service.IgniteCacheService;
import org.apache.ignite.cache.spring.SpringCacheManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cache.Cache;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class IgniteCacheServiceImpl implements IgniteCacheService {


    @Autowired
    @Qualifier("cacheManager")
    private SpringCacheManager cacheManager;

    @Override
    public Collection<String> getAllCacheNames() {
        return cacheManager.getCacheNames();
    }

    @Override
    public Object getCacheValue(String cacheName, String key) {
        Cache cache = cacheManager.getCache(cacheName);
        Cache.ValueWrapper valueWrapper = cache.get(key);
        return valueWrapper.get();
    }
}
