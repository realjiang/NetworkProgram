package com.superj.tcp.upload;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

//服务端（先启动，等待客户端连接）
public class TcpUploadServer {
    public static void main(String[] args) throws IOException{
        //1.创建服务
        ServerSocket serverSocket = new ServerSocket(9000);
        //2.监听客户端的连接-阻塞式监听，会一直等待客户端连接
        Socket socket = serverSocket.accept();
        //3.获取输入流
        InputStream is = socket.getInputStream();
        //4.文件输出
        FileOutputStream fos = new FileOutputStream(new File("getPic.jpeg"));
        byte[] buffer = new byte[1024];
        int len;
        while ((len = is.read(buffer)) != -1) {
            fos.write(buffer,0,len);
        }
        //通知客户端接收完毕
        OutputStream os = socket.getOutputStream();
        os.write("接收完毕，可以断开连接了".getBytes());

        //关闭流，连接
        os.close();
        fos.close();
        is.close();
        socket.close();
        serverSocket.close();
    }
}
