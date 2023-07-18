package com.babyblue.july18;

import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

import static java.nio.charset.StandardCharsets.UTF_8;

public class Server {

    public static void main(String[] args) {


        try (ServerSocket serverSocket = new ServerSocket(8080)) {
            Socket socket = serverSocket.accept();
            // 从网络上拿到一个数据输入流
            InputStream is = socket.getInputStream();
            int len;
            byte[] buf = new byte[1024];
            while ((len = is.read(buf)) != -1) {
                System.out.println(new String(buf, 0, len, UTF_8));
            }
            is.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
