package com.superj.udp.msg;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

//受消息
//并不是真正意义上的服务器，只用于区分接收方与发送方
public class UdpMsgServer {
    public static void main(String[] args) throws Exception {
        // 开放端口
        DatagramSocket socket = new DatagramSocket(9090);
        //接收数据（包）
        byte[] buffer = new byte[1024];
        DatagramPacket packet = new DatagramPacket(buffer, 0, buffer.length);
        socket.receive(packet);//阻塞接收
        System.out.println(packet.getAddress());
        System.out.println(new String(packet.getData(), 0, packet.getLength()));
        //关闭连接
        socket.close();
    }
}
