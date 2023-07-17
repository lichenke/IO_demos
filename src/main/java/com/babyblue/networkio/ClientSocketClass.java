package com.babyblue.networkio;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class ClientSocketClass {
    // 启动一个客户端，连接到服务端
    final static int PORT = 8080;

    public static void main(String[] args) {
        try (Socket socket = new Socket("localhost", PORT)) {
            BufferedWriter bw =  new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            bw.write("我是客户端发送的消息\n");
            bw.flush();
            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String str = br.readLine();
            System.out.println("收到服务端的信息: " + str);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
