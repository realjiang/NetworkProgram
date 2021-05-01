package com.superj.udp.msg;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

//发消息
public class UdpMsgClient {
    public static void main(String[] args) throws Exception {
        //1 建立一个Socket
        DatagramSocket socket = new DatagramSocket();
        //2 建个包
        // 发送内容
        String msg = "hello,server!";
        // 发送给谁
        InetAddress localhost = InetAddress.getByName("localhost");
        int port = 9090;
        //数据包参数：数据，数据的长度起始，发送给谁 ip+端口
        DatagramPacket packet = new DatagramPacket(msg.getBytes(), 0, msg.getBytes().length, localhost, port);
        //3 发送包
        socket.send(packet);
        //4 关闭流
        socket.close();
    }
}
