package com.superj.udp.online;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;

//开启两个线程，既是发送方，又是接收方
public class UdpTalkTest1 {
    public static void main(String[] args) throws IOException {
        new Thread(new UdpOnlineTalkSend(7777,"localhost",9999)).start();
        new Thread(new UdpOnlineTalkReceive(8888)).start();
    }
}
