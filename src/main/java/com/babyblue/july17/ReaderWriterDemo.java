package com.babyblue.july17;

import java.io.FileReader;

public class ReaderWriterDemo {

    public static void main(String[] args) {

        try (FileReader fr = new FileReader("/Users/lichenke/Desktop/test")) {
            int len;
            while ((len = fr.read()) != -1) {
                System.out.print((char) len);
            }
        } catch (Exception e) {

        }
    }
}
