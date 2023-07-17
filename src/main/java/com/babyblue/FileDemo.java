package com.babyblue;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

public class FileDemo {

    /*
       获取一个输入的绝对路径地址，然后将该地址下的所有文件遍历出来
     */
    public static void main(String[] args) {

        try (InputStreamReader reader = new InputStreamReader(System.in);
             BufferedReader br = new BufferedReader(reader)) {
            String path = br.readLine();
            File file = new File(path);
            if (file.isDirectory() && file.exists()) {
                listFile(file);
            } else {
                System.out.println("文件路径输入错误");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void listFile(File filePath) {
        File[] files = filePath.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    System.out.println(file.getName());
                } else {
                    listFile(file);
                }
            }
        }
    }
}
