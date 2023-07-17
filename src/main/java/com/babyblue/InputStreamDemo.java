package com.babyblue;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class InputStreamDemo {

    public static void main(String[] args) {
        // 文件的复制
        try (FileInputStream fis = new FileInputStream("/Users/lichenke/Desktop/test/test.txt");
            FileOutputStream fos = new FileOutputStream("/Users/lichenke/Desktop/test/test2.txt")) {
            int len;
            byte[] buf = new byte[8188];
            while ((len = fis.read(buf)) != -1) {
               fos.write(buf, 0, len);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
