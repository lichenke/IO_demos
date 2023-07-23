package com.babyblue.july20;

import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class NIOWriteDemo {

    public static void main(String[] args) {

        try(FileOutputStream fos = new FileOutputStream("/Users/lichenke/Desktop/2.txt")) {

            FileChannel channel = fos.getChannel();
            ByteBuffer buf = ByteBuffer.allocate(1024);
            buf.put("我就是爱音乐别让我停下来\n".getBytes());
            buf.put("\uF8FF ~/.m2/repository/com/babyblue/rpc-client/1.0/ ls".getBytes());
            buf.flip();
            System.out.println(channel.write(buf));
        } catch (Exception e) {

        }
    }
}
