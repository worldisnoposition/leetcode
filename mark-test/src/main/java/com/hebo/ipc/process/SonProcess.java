package com.hebo.ipc.process;

import java.io.*;

public class SonProcess {
    private final static String sonValue = "son value to write";

    public static void main(String[] args) throws IOException, InterruptedException {
        BufferedReader s = new BufferedReader(new InputStreamReader(System.in));
        String line;
        StringBuffer all = new StringBuffer();
        //system.out.println可以作为输出，被父进程读取
        System.out.println("son start accept father value");
        while ((line = s.readLine()) != null) {
            all.append(line);
        }
        System.out.println("son end accept father value:" + all);
        s.close();
        //也可以把system.out作为流，自己往里面写东西
        BufferedWriter b = new BufferedWriter(new OutputStreamWriter(System.out));
        b.write(sonValue);
        b.flush();
        b.close();
    }
}