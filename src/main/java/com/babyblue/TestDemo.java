package com.babyblue;

import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class TestDemo {

    public static void main(String[] args) {
        // 1,基于磁盘
        int len;
        byte[] buf = new byte[3];
        try (FileInputStream fis = new FileInputStream("/Users/lichenke/Desktop/test/test.txt")) {
            while ((len = fis.read(buf)) != -1) {
                System.out.print(new String(buf, 0, len));
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        // 2,基于内存
        String str = "hello world";
        ByteArrayInputStream bais = new ByteArrayInputStream(str.getBytes());
        byte[] buf2 = new byte[3];
        int len2;
        try {
            while ((len2 = bais.read(buf2)) != -1) {
                System.out.print(new String(buf2, 0, len2));
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        // 3,基于键盘
        InputStream is = System.in;
        int len3;
        byte[] buf3 = new byte[3];
        try {
            while ((len3 = is.read(buf3)) != -1) {
                System.out.print(new String(buf3, 0, len3));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // 4,基于网络
        // Socket socket = new Socket();
        // socket.getInputStream();
        // socket.getOutputStream()
    }

}
