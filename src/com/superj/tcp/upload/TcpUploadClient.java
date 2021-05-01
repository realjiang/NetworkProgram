package com.superj.tcp.upload;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

//客户端
public class TcpUploadClient {
    public static void main(String[] args) throws IOException{
            //1.要知道服务器的地址，端口号;创建一个socket连接
            Socket socket = new Socket(InetAddress.getByName("127.0.0.1"), 9000);
            //2.发送消息 创建输出流
            OutputStream os = socket.getOutputStream();
            //3.读取文件
            FileInputStream fis = new FileInputStream(new File("duck.jpeg"));
            //4.写出文件
            byte[] buffer = new byte[1024];
            int len;
            while ((len = fis.read(buffer)) != -1) {
                os.write(buffer, 0, len);
            }
            //通知服务器，我已传输完毕
            socket.shutdownOutput();
            //确定服务器接收完毕，才能断开连接
            InputStream is = socket.getInputStream();
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            byte[] buffer2 = new byte[1024];
            int len2;
            while ((len2 = is.read(buffer2)) != -1) {
                baos.write(buffer2, 0, len2);
            }
            System.out.println(baos.toString());

            //关闭流，连接
            baos.close();
            is.close();
            fis.close();
            os.close();
            socket.close();
    }
}
