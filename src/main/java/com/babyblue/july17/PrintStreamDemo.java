package com.babyblue.july17;

import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;

public class PrintStreamDemo {

    public static void main(String[] args) {
        PrintStream out = System.out;
        // 默认情况下，PrintStream输出数据的位置是标准输出，及显示器
        out.println("hello world");
        out.close();

        // 因为print底层使用的是write，所以我们可以直接调用write进行打印输出
        try {
            out.write("hello world".getBytes());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // 我们可以修改打印流输出的位置/设备
        try {
            // 将输出位置修改为了/Users/chenke/Desktop/hello.txt
            System.setOut(new PrintStream("/Users/lichenke/Desktop/hello.txt"));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        PrintStream out1 = System.out;
        // 修改了输出位置后，分别用println和write打印内容
        out1.println("hello world");
        try {
            out1.write("hello world by byte[]".getBytes());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    @Test
    public void test() {
        try (PrintStream ps = new PrintStream("/Users/lichenke/Desktop/hello1.txt")) {
            ps.println("xxx");

        } catch (Exception e) {

        }

    }
}
