package com.babyblue.july17;

import org.junit.jupiter.api.Test;

import java.io.FileInputStream;

public class FileInputStreamDemo {

    @Test
    public void test1() {
        String path = "/Users/lichenke/IdeaProjects/personal/IO/hello.txt";
        byte[] buf = new byte[3];
        int len;
        try (FileInputStream fis = new FileInputStream(path)) {
            while ((len = fis.read(buf)) != -1) {
                System.out.print(new String(buf, 0, len));
            }
        } catch (Exception e) {
            throw new RuntimeException("报错了", e);
        }
    }
}
