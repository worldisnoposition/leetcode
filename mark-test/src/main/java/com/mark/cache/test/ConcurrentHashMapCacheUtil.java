package com.mark.cache.test;

import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapCacheUtil implements CacheUtil {
    volatile ConcurrentHashMap<String, String> concurrentHashMap = new ConcurrentHashMap<>(16);

    @Override
    public void set(String key, String value) {
        concurrentHashMap.put(key, value);
    }

    @Override
    public String get(String key) {
        return concurrentHashMap.get(key);
    }

    @Override
    public String info() {
        return "size=" + concurrentHashMap.size();
    }
}
