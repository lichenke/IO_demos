package com.babyblue;

import java.io.FileInputStream;

public class FileInputStreamDemo {

    public static void main(String[] args) {

        int len;
        byte[] buf = new byte[3];
        try (FileInputStream fis = new FileInputStream("/Users/lichenke/Desktop/test/test.txt")) {
            while((len = fis.read(buf)) != -1) {
                System.out.print(new String(buf, 0, len));
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
