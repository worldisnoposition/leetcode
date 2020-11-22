package com.hebo.cache.test;

import java.util.concurrent.ExecutionException;

public interface CacheUtil {
    void set(String key, String value);

    String get(String key) throws ExecutionException;

    String info();
}
