package com.babyblue;

import java.io.ByteArrayInputStream;

public class MemoryDemo {

    public static void main(String[] args) {
        String str = "hello world";

        ByteArrayInputStream bais = new ByteArrayInputStream(str.getBytes());
        int len;
        byte[] buf = new byte[3];
        try {
            while ((len = bais.read(buf)) != -1) {
                String s = new String(buf, 0, len);
                System.out.println(s);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        // 不需要进行流的关闭，因为没有用到外部的资源
    }
}
