package com.superj.udp.online;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

//在线咨询-接收
public class UdpOnlineTalkReceive implements Runnable{

    private int myPort;
    private String senderName;

    DatagramSocket socket = null;

    public UdpOnlineTalkReceive(int myPort) {
        this.myPort = myPort;
        try {
            socket = new DatagramSocket(this.myPort);
        } catch (SocketException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        while (true) {
            try {
                //准备接收包裹
                byte[] container = new byte[1024];
                DatagramPacket packet = new DatagramPacket(container, 0, container.length);
                socket.receive(packet);
                //断开连接
                byte[] data = packet.getData();
                String receiveData = new String(data, 0, data.length);
                this.senderName = packet.getAddress().getHostName()+"-"+packet.getPort();
                System.out.println(this.senderName+":"+receiveData);
                if (receiveData.equals("bye")) {
                    break;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        socket.close();
    }
}
