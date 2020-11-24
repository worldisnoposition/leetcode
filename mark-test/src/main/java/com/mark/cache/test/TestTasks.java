package com.mark.cache.test;

public class TestTasks {
    static TaskManager taskManager = new TaskManager();

    public static void main(String[] args) {
        int size = 1000000;
        CaffeineCacheUtil caffeineCacheUtil = new CaffeineCacheUtil();
        ConcurrentHashMapCacheUtil concurrentHashMapCacheUtil = new ConcurrentHashMapCacheUtil();
        long time = taskManager.startTasks(caffeineCacheUtil, size);
        System.out.println(caffeineCacheUtil.info());
        System.out.println(time);

        time = taskManager.startTasks(concurrentHashMapCacheUtil, size);
        System.out.println(concurrentHashMapCacheUtil.info());
        System.out.println(time);

    }
}
