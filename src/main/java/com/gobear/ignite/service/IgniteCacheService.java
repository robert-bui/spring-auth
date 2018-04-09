package com.gobear.ignite.service;

import java.util.Collection;

public interface IgniteCacheService {

    Collection<String> getAllCacheNames();

    Object getCacheValue(String cacheName, String key);
}
