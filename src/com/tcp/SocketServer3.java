package com.tcp;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServer3 {
    public static void main(String[] args) {
        int port = 55533; // 监听指定的端口
        try {
            ServerSocket server = new ServerSocket(port); //1：创建服务器的Socker  在Java中对应的API是ServerSocket.
            System.out.println("服务器将一直等待连接的到来");
            Socket socket = server.accept();//2:服务器只要获取到连接过来的客户端就可以和指定的客户端通信了。
            InputStream inputStream = socket.getInputStream();// 3:建立好连接后，从socket中获取输入流，并建立缓冲区进行读取
            //4:在服务器端输出客户端发送过来的数据。
            byte[] bytes;
            // 因为可以复用Socket且能判断长度，所以可以一个Socket用到底
            while (true) {
                // 首先读取两个字节表示的长度
                int first = inputStream.read();
                //如果读取的值为-1 说明到了流的末尾，Socket已经被关闭了，此时将不能再去读取
                if(first==-1){
                    break;
                }
                int second = inputStream.read();
                int length = (first << 8) + second;
                // 构造一个指定长的byte数组
                bytes = new byte[length];
                // 读取指定长度的消息即可
                inputStream.read(bytes);
                System.out.println("从客户端得到的信息: " + new String(bytes, "UTF-8"));
            }
            OutputStream outputStream = socket.getOutputStream();
            outputStream.write("Hello Client,我得到你发送过来的信息了".getBytes("UTF-8"));
            inputStream.close();
            outputStream.close();
            socket.close();
            server.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
