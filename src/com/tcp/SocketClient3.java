package com.tcp;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * 通过TCP传输将数据发送给服务器。
 */
public class SocketClient3 {
    /**
     *
     */
    public static void main(String[] args) {
        System.out.println("客户端开始运行。。。");
        String host = "127.0.0.1";    int port = 55533;//要连接的服务端IP地址和端口
        try {
            Socket socket = new Socket(host, port); //1:建立客户端Socket。
            OutputStream outputStream = socket.getOutputStream();//2:建立连接后获得输出流
            String message = "第一条消息";
            //首先需要计算得知消息的长度
            byte[] sendBytes = message.getBytes("UTF-8");
            //然后将消息的长度优先发送出去
            outputStream.write(sendBytes.length >>8);
            outputStream.write(sendBytes.length);
            //然后将消息再次发送出去
            outputStream.write(sendBytes);
            outputStream.flush();
            message = "第二条消息";
            sendBytes = message.getBytes("UTF-8");
            outputStream.write(sendBytes.length >>8);
            outputStream.write(sendBytes.length);
            outputStream.write(sendBytes);
            outputStream.flush();
            message = "第三条消息";
            sendBytes = message.getBytes("UTF-8");
            outputStream.write(sendBytes.length >>8);
            outputStream.write(sendBytes.length);
            outputStream.write(sendBytes);
            socket.shutdownOutput();//4:通过shutdownOutput高速服务器已经发送完数据，后续只能接受数据
            InputStream inputStream = socket.getInputStream();
            byte[] bytes = new byte[1024];
            int len;
            StringBuffer stringBuffer = new StringBuffer();
            while ((len = inputStream.read(bytes)) != -1) {
                stringBuffer.append(new String(bytes, 0, len, "UTF-8"));
            }
            System.out.println("从服务器获得："+stringBuffer);
            inputStream.close();
            outputStream.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
