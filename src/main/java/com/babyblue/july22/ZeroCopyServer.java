package com.babyblue.july22;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.file.Paths;
import java.util.EnumSet;

import static java.nio.file.StandardOpenOption.*;

public class ZeroCopyServer {

    static final String target = "/Users/lichenke/Downloads/code.zip";

    public static void main(String[] args) {
        try (ServerSocketChannel serverSocketChannel = ServerSocketChannel.open()) {
            serverSocketChannel.socket().bind(new InetSocketAddress(8080));
            System.out.println("Server listening on: 8080");
            SocketChannel socketChannel = serverSocketChannel.accept();
            System.out.println("Connection in:  " + socketChannel.getRemoteAddress());
            ByteBuffer bf = ByteBuffer.allocate(2048);
            try (FileChannel fileChannel = FileChannel.open(Paths.get(target), EnumSet.of(CREATE, TRUNCATE_EXISTING, WRITE))) {
                while ((socketChannel.read(bf)) != -1) {
                    bf.flip();
                    fileChannel.write(bf);
                    bf.clear();
                }
            }
            System.out.println("File received");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
