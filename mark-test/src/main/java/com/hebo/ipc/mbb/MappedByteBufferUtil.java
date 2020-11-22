package com.hebo.ipc.mbb;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

public class MappedByteBufferUtil {
    private static final String filename = "D:\\lock.lock";
    private static final byte NON_LOCK = 0;
    private static final byte S_LOCK = 1;
    private static final byte X_LOCK = 2;
    private static final long lockTime = 100000L;

    public boolean write(String value, long lockTime) throws IOException {
        RandomAccessFile randomAccessFile = null;
        try {
            randomAccessFile = new RandomAccessFile(filename, "rw");
            FileChannel fileChannel = randomAccessFile.getChannel();
            int size = 500;
            MappedByteBuffer mappedByteBuffer = fileChannel.map(FileChannel.MapMode.READ_WRITE, 0, size);

            long time = System.currentTimeMillis();
            mappedByteBuffer.put(X_LOCK);
//            mappedByteBuffer.put(S_LOCK);
//            for (int i = 1; i < 100; i++) {
//                mappedByteBuffer.putInt(i);
//            }
//            while (System.currentTimeMillis() - time < lockTime) {
////                mappedByteBuffer.putInt(1);
//                mappedByteBuffer.put(value.getBytes());
////                mappedByteBuffer.putInt(READ_MODE);
//                mappedByteBuffer.put(NON_LOCK);
//                return true;
//            }
            return false;
        } finally {
            if (randomAccessFile != null) {
                randomAccessFile.close();
            }
        }
    }

    public void read() throws IOException {
//        MappedByteBuffer mappedByteBuffer = null;
        StringBuilder sb = new StringBuilder();
        RandomAccessFile randomAccessFile = null;
        try {
            randomAccessFile = new RandomAccessFile(filename, "r");
            FileChannel fileChannel = randomAccessFile.getChannel();
            int size = 500;
            MappedByteBuffer mappedByteBuffer = fileChannel.map(FileChannel.MapMode.READ_ONLY, 0, size);
            byte[] bytes = new byte[size + 1];
            switch (mappedByteBuffer.get(0)) {
                case S_LOCK:
                    read(mappedByteBuffer, bytes);
                case X_LOCK:
                    tryRead(mappedByteBuffer, bytes, lockTime);
                default:
                    read(mappedByteBuffer, bytes);
            }
//                    Thread.sleep(200L);
//            byte a = mappedByteBuffer.get();
//            System.out.println(a);
//                    byte b = mappedByteBuffer.get();
//                    bb[mappedByteBuffer.position()] = b;
////                    sb.append(new String(bb));
//                    System.out.println(new String(bb));
//        } catch (InterruptedException e) {
//            e.printStackTrace();
        } finally {
            if (randomAccessFile != null) {
                randomAccessFile.close();
            }
        }
//        return null;
    }

    private void tryRead(MappedByteBuffer mappedByteBuffer, byte[] bytes, long lockTime) {
        long time = System.currentTimeMillis();
        while (System.currentTimeMillis() - time < lockTime) {
            if (mappedByteBuffer.get(0) < X_LOCK) {
                read(mappedByteBuffer, bytes);
                return;
            }
            sleep();
            System.out.println("waiting");

        }
        throw new RuntimeException("time out");
    }

    private void sleep() {
        try {
            Thread.sleep(100L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void read(MappedByteBuffer mappedByteBuffer, byte[] bytes) {
//        mappedByteBuffer.put(0, S_LOCK);
        while (mappedByteBuffer.hasRemaining()) {
            mappedByteBuffer.get(bytes, 0, mappedByteBuffer.remaining());
            System.out.println(bytes[0]);
        }
//        mappedByteBuffer.put(0, NON_LOCK);
    }
}
