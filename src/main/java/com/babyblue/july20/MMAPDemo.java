package com.babyblue.july20;

import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Paths;

import static java.nio.file.StandardOpenOption.*;

public class MMAPDemo {

    public static void main(String[] args) {
        try (FileChannel fin = FileChannel.open(Paths.get("/Users/lichenke/Desktop/代码.zip"), READ);
             FileChannel fout = FileChannel.open(Paths.get("/Users/lichenke/Desktop/代码1.zip"), READ, WRITE, CREATE)) {
            // 直接开辟两个map进行映射，不涉及内核空间和用户空间的频繁拷贝
            // 读通道，仅读取
            MappedByteBuffer inMapBuf = fin.map(FileChannel.MapMode.READ_ONLY, 0, fin.size());
            // 写通道，读写
            MappedByteBuffer outMapBuf = fout.map(FileChannel.MapMode.READ_WRITE, 0, fin.size());

            byte[] bytes = new byte[inMapBuf.limit()];
            inMapBuf.get(bytes); // 读取到bytes中
            outMapBuf.put(bytes); // 将byte写入buf中
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
