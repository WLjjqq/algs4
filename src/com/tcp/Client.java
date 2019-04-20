package com.tcp;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

/**
 * 通过TCP传输将数据发送给服务器。
 */
public class Client {
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
        //要连接的服务端IP地址和端口
        String host = "127.0.0.1";
        int port = 55533;
        try {
            //1:建立客户端Socket。
            Socket socket = new Socket(host, port);
            //2:建立连接后获得输出流
            OutputStream outputStream = socket.getOutputStream();
            //3：将数据发出。
            outputStream.write("Hello,这是客户端1发送请求".getBytes("UTF-8"));
            //4:关闭socket。不用关闭流。因为流是从socket中获取的。socket都没有了。流自然也就关闭了。
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
