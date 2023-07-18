package com.babyblue.july17;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.nio.file.Paths;

import static java.nio.file.Files.newOutputStream;

public class FlushDemo {

    public static void main(String[] args) throws IOException {
        try(BufferedOutputStream bos = new BufferedOutputStream(newOutputStream(Paths.get("/Users/lichenke/Desktop/test/test123.txt")))) {
            bos.write("hello world".getBytes());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        BufferedOutputStream bos2 = new BufferedOutputStream(newOutputStream(Paths.get("/Users/lichenke/Desktop/test/test1234.txt")));
        bos2.write("hello world".getBytes());
        // 执行完成后会发现目标文件中没有要写入的信息
        // 原因：hello world这串字符没有填满8K的默认缓冲，所以没有执行写入磁盘的操作
        // 解决方案：执行flush()方法，进行刷盘操作
        bos2.flush();
        bos2.close(); // close()方法也会调用flush()进行刷盘操作
    }
}
