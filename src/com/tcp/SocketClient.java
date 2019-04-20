package com.tcp;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * 通过TCP传输将数据发送给服务器。
 */
public class SocketClient {
    /**
     * 思路：
     * 1：建立TCP的客户端Socket。明确服务器的地址和端口。
     * 2：如果通道建立成功就会出现socket io流。
     *      客户端要做的就是获取socket流中的输出流将数据发送给服务端。
     * 3：通过socket输出流将数据发送。
     * 4：关闭资源。
     */
    public static void main(String[] args) {
        System.out.println("客户端开始运行。。。");
        String host = "127.0.0.1";    int port = 55533;//要连接的服务端IP地址和端口
        try {
            Socket socket = new Socket(host, port); //1:建立客户端Socket。
            OutputStream outputStream = socket.getOutputStream();//2:建立连接后获得输出流
            outputStream.write("Hello,这是客户端2发送请求".getBytes("UTF-8")); //3：将数据发出。
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
