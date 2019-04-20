package com.tcp;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServer {
    public static void main(String[] args) {
        int port = 55533; // 监听指定的端口
        try {
            ServerSocket server = new ServerSocket(port); //1：创建服务器的Socker  在Java中对应的API是ServerSocket.
            System.out.println("服务器将一直等待连接的到来");
            Socket socket = server.accept();//2:服务器只要获取到连接过来的客户端就可以和指定的客户端通信了。
            InputStream inputStream = socket.getInputStream();// 3:建立好连接后，从socket中获取输入流，并建立缓冲区进行读取
            //4:在服务器端输出客户端发送过来的数据。
            byte[] bytes = new byte[1024];
            int len;
            StringBuilder sb = new StringBuilder();
            while ((len = inputStream.read(bytes)) != -1) {
                sb.append(new String(bytes, 0, len,"UTF-8"));
            }
            System.out.println("从客户端获得: " + sb);
            OutputStream outputStream = socket.getOutputStream();
            outputStream.write("Hello Client,我得到你发送过来的信息了".getBytes("UTF-8"));
            inputStream.close(); outputStream.close(); socket.close();  server.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
