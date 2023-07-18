package com.babyblue.july17;

import org.junit.jupiter.api.Test;

import java.io.*;
import java.nio.file.Paths;


import static java.nio.file.Files.newInputStream;
import static java.nio.file.Files.newOutputStream;

public class InputStreamReaderDemo {

    @Test
    public void encode() {
        //1. 使用InputStreamReader转换流解决中文乱码问题
        String src = "/Users/lichenke/Desktop/test";
        //2. 将字节流FileInputStream，转为字符流InputStreamReader
        String line;
        try (InputStreamReader isr = new InputStreamReader(newInputStream(Paths.get(src)));
             BufferedReader br = new BufferedReader(isr)) {
            //3. 使用BufferedReader封装InputStreamReader，同时拥有了缓冲机制和解决编码问题的功能
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {

        }
    }


    public static void main(String[] args) {
        String src = "/Users/lichenke/Desktop/text.txt";
        try (OutputStreamWriter osw = new OutputStreamWriter(newOutputStream(Paths.get(src)),
                "gbk");
             BufferedWriter bw = new BufferedWriter(osw)) {
            bw.write("你好世界");
            bw.newLine();
            bw.write("世界你好");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
