package com.babyblue;

import java.io.FileReader;

public class ReaderWriterDemo {

    public static void main(String[] args) {
        try (FileReader reader = new FileReader("/Users/lichenke/Desktop/test/test123.txt")) {
            int len;
            char[] buf = new char[1024];
            while((len = reader.read(buf)) != -1) {
                System.out.println(new String(buf, 0, len));
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
