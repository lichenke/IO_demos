package com.babyblue.july20;

import java.io.FileInputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class NIOReadDemo {

    public static void main(String[] args) {

        try (FileInputStream fis = new FileInputStream("/Users/lichenke/Desktop/1.txt")) {
            FileChannel fic = fis.getChannel();
            ByteBuffer buf = ByteBuffer.allocate(1024);
            fic.read(buf);
            System.out.println(new String(buf.array()));
        } catch (Exception e) {

        }
    }
}
