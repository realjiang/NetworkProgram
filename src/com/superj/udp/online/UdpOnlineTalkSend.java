package com.superj.udp.online;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;

//在线咨询-发送
public class UdpOnlineTalkSend implements Runnable{

    private int fromPort;
    private String toIp;
    private int toPort;

    DatagramSocket socket = null;
    BufferedReader reader = null;

    public UdpOnlineTalkSend(int fromPort, String toIp, int toPort) {
        this.fromPort = fromPort;
        this.toIp = toIp;
        this.toPort = toPort;
        try {
            socket = new DatagramSocket(this.fromPort);
            reader = new BufferedReader(new InputStreamReader(System.in));
        } catch (SocketException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        while (true) {
            try {
//                System.out.print("localhost-" + this.fromPort+"(me):");
                String data = reader.readLine();
                byte[] datas = data.getBytes();
                DatagramPacket packet = new DatagramPacket(datas, 0, datas.length, new InetSocketAddress(this.toIp, this.toPort));
                //3 发送包
                socket.send(packet);
                //断开连接
                if (data.equals("bye")) {
                    break;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        //4 关闭流
        socket.close();
    }
}
