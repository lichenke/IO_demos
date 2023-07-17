package com.babyblue.networkio;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ServerSocketClass {
    // 启动一个服务端
    final static int PORT = 8080;

    public static void main(String[] args) {
        try (ServerSocket s = new ServerSocket(PORT)) {
            ExecutorService executor = Executors.newFixedThreadPool(4);
            while (true) { //
                Socket socket = s.accept();
                // 异步的使用线程池进行客户端的服务请求处理
                executor.submit(new ServerSocketThread(socket));
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    static class ServerSocketThread implements Runnable {

        Socket socket;

        public ServerSocketThread(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                System.out.println("客户端：" + socket.getPort() + "已连接");
                BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                String str = br.readLine();
                System.out.println("收到客户端的请求信息: " + str);
                Thread.sleep(15000);
                BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
                bw.write("我已经收到了消息\n");
                bw.flush();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }
}
