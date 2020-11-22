package com.hebo.cache.test;

import org.checkerframework.checker.units.qual.C;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;

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
