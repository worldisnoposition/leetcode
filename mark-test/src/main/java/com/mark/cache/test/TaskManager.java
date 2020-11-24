package com.mark.cache.test;

import java.util.concurrent.*;

public class TaskManager {
    //    Semaphore semaphore = new Semaphore(100);
    volatile CountDownLatch countDownLatch = null;

    public long startTasks(CacheUtil cacheUtil, int taskNum) {
        ExecutorService pool = Executors.newFixedThreadPool(10);

        long time = System.currentTimeMillis();

        countDownLatch = new CountDownLatch(taskNum);
        for (int i = 0; i < taskNum; i++) {
            pool.execute(startTask(cacheUtil, String.valueOf(i), String.valueOf(i)));
        }
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        time = System.currentTimeMillis() - time;
        pool.shutdown();
        return time;
    }

    private Runnable startTask(CacheUtil cacheUtil, String k, String v) {
        return () -> {
            for (int i = 0; i < 100; i++) {
                cacheUtil.set(k + "-" + i, v + "-" + i);
            }
            countDownLatch.countDown();
//            System.out.println(k + " is end");
        };
    }
}
