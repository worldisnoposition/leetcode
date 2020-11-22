package com.hebo.ipc.mbb;

import java.io.IOException;

public class MbbProducer {
    public static void main(String[] args) throws IOException {
        MappedByteBufferUtil mappedByteBufferUtil = new MappedByteBufferUtil();
        mappedByteBufferUtil.write("12345abcde中文呢", 9000L);
    }
}
