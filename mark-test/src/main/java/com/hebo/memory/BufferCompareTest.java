package com.hebo.memory;

import com.google.common.base.Stopwatch;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.concurrent.*;

public class BufferCompareTest {
    private static final String filename = "D:\\lock.lock";
    //    private static final int size = 50000;
//    private static final ForkJoinPool pool = new ForkJoinPool(3);
    private static final ExecutorService pool = Executors.newFixedThreadPool(3);

    public static void main(String[] args) throws IOException, ExecutionException, InterruptedException {
        Stopwatch stopwatch = Stopwatch.createStarted();
        statistic(500);

        System.out.println("Buffer\tDirectBuffer\tMappedByteBuffer");
        for (int size = 100; size < 100000000; size *= 10) {
            for (int i = 0; i < 5; i++) {
                statistic(size);
            }
        }
        pool.shutdown();
        System.out.println("cost total time:" + stopwatch.stop().toString());
    }

    private static void statistic(int size) throws IOException, ExecutionException, InterruptedException {

        ByteBuffer buffer = ByteBuffer.allocate(size);
        ByteBuffer directBuffer = ByteBuffer.allocateDirect(size);

        RandomAccessFile randomAccessFile = new RandomAccessFile(filename, "rw");
        FileChannel fileChannel = randomAccessFile.getChannel();
        MappedByteBuffer mappedByteBuffer = fileChannel.map(FileChannel.MapMode.READ_WRITE, 0, size);
        Future<Long> bufferFuture = executeFuture(buffer, size);
        Future<Long> directFuture = executeFuture(directBuffer, size);
        Future<Long> mappedFuture = executeFuture(mappedByteBuffer, size);
        System.out.println(bufferFuture.get() + "\t" + directFuture.get() + "\t" + mappedFuture.get());
    }

    private static Future<Long> executeFuture(ByteBuffer buffer, int size) {
        return pool.submit(() -> costTime(buffer, size));
    }

    private static long costTime(ByteBuffer buffer, int size) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            for (int j = 0; j < size / 4; j++) {
                buffer.putInt(j);           //向DirectBuffer写入数据
            }
            buffer.flip();
            for (int j = 0; j < size / 4; j++) {
                buffer.get();                   //从DirectBuffer中读取数据
            }
            buffer.clear();
        }
        return (System.currentTimeMillis() - start);
    }
}
