package com.mark.ipc.mbb;

//import sun.misc.Contended;

import java.io.IOException;

public class MbbConsumer {
    public static void main(String[] args) throws IOException {
        MappedByteBufferUtil mappedByteBufferUtil = new MappedByteBufferUtil();
        mappedByteBufferUtil.read();



    }

}
//@Contended
 class VolatileLong {
    public volatile long value = 0L;
}
