package com.tcp;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        // 监听指定的端口
        int port = 55533;
        try {
            //1：创建服务器的Socker  在Java中对应的API是ServerSocket.
            ServerSocket server = new ServerSocket(port);
            // server将一直等待连接的到来
            System.out.println("server将一直等待连接的到来");
            //2:服务器只要获取到连接过来的客户端就可以和指定的客户端通信了。
            Socket socket = server.accept();
            // 3:建立好连接后，从socket中获取输入流，并建立缓冲区进行读取
            InputStream inputStream = socket.getInputStream();
            //4:在服务器端输出客户端发送过来的数据。
            byte[] bytes = new byte[1024];
            int len;
            StringBuilder sb = new StringBuilder();
            while ((len = inputStream.read(bytes)) != -1) {
                //注意指定编码格式，发送方和接收方一定要统一，建议使用UTF-8
                sb.append(new String(bytes, 0, len,"UTF-8"));
            }
            System.out.println("get message from client: " + sb);
            socket.close();
            server.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
