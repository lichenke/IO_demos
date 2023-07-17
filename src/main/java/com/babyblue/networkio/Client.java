package com.babyblue.networkio;

import java.io.OutputStream;
import java.net.Socket;

import static java.nio.charset.StandardCharsets.UTF_8;

public class Client {

    public static void main(String[] args) {
        try (Socket socket = new Socket("localhost", 8080)) {
            OutputStream os = socket.getOutputStream();
            os.write("hello".getBytes(UTF_8));
            os.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
