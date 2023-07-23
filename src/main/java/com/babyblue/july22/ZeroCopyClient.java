package com.babyblue.july22;

import java.net.InetSocketAddress;
import java.nio.channels.FileChannel;
import java.nio.channels.SocketChannel;
import java.nio.file.Paths;

public class ZeroCopyClient {

    public static void main(String[] args) {
        try (SocketChannel socketChannel = SocketChannel.open()) {
            socketChannel.connect(new InetSocketAddress("localhost", 8080));
            try (FileChannel fileChannel = FileChannel.open(Paths.get("/Users/lichenke/Desktop/代码.zip"))) {
                int pos = 0;
                long size = fileChannel.size();
                while (size > 0) {
                    long len = fileChannel.transferTo(pos, size, socketChannel);
                    if (len > 0) {
                        pos += len;
                        size -= len;
                    }
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
