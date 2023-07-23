package com.babyblue.july20;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class NIODemo {

    public static void main(String[] args) {
        // 文件复制
        try (FileInputStream fis = new FileInputStream("/Users/lichenke/Desktop/IMG_7011.HEIC");
             FileOutputStream fos = new FileOutputStream("/Users/lichenke/Desktop/IMG_7011_cp1.HEIC")) {
            // NIO获取通道
            FileChannel fic = fis.getChannel();
            FileChannel foc = fos.getChannel();
            ByteBuffer buf = ByteBuffer.allocate(1024 * 8); //必须指定一个buf，NIO是面向缓冲区的
            while((fic.read(buf)) != -1) { // 将信息读到缓冲区
                buf.flip(); // 翻转buf
                foc.write(buf);
                buf.clear(); // 必须把buf清空
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
