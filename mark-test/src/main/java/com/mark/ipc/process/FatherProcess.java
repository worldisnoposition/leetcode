package com.mark.ipc.process;

import java.io.*;

public class FatherProcess {
    private final static String toWrite = "value in father";

    public static void main(String[] args) throws IOException, InterruptedException {
        Runtime run = Runtime.getRuntime();
        String java = System.getProperty("java.home") + File.separator + "bin" + File.separator + "java";
        String cp = "\"" + System.getProperty("java.class.path");
        cp += File.pathSeparator + ClassLoader.getSystemResource("").getPath() + "\"";
        String cmd = "java -cp " + cp + " com.hebo.ipc.process.SonProcess";
        Process p = run.exec(cmd);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(p.getOutputStream()));
        System.out.println("father start write:" + toWrite);
        bw.write(toWrite);
        bw.flush();
        bw.close();
        System.out.println("father end write:" + toWrite);

        BufferedInputStream in = new BufferedInputStream(p.getInputStream());
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        String s;
        while ((s = br.readLine()) != null) {
            System.out.println("father accept son's value:" + s);
        }
        System.out.println();
        System.out.println("father accept son's value is end");

    }
}