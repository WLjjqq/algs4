package com.tcp;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SocketServerThread {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(55533);
            serverSocket.setSoTimeout(5*1000);
            System.out.println("服务端在等待着客户端发送请求");
            //使用线程池的好处：防止并发过高时创建过多线程耗尽资源
            ExecutorService threadPool = Executors.newFixedThreadPool(100);
            while (true) {
                Socket socket = serverSocket.accept();
                Runnable runnable=()->{
                    try {
                        InputStream inputStream = socket.getInputStream();
                        byte[] bytes = new byte[1024];
                        int len;
                        StringBuilder stringBuilder = new StringBuilder();
                        while ((len = inputStream.read(bytes)) != -1) {
                            stringBuilder.append(new String(bytes, 0, len, "UTF-8"));
                        }
                        System.out.println("从客户端发送过来的信息：" + stringBuilder);
                        inputStream.close();
                        socket.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                };
                threadPool.submit(runnable);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
