package com.superj.udp.online;

import java.io.IOException;

//开启两个线程，既是发送方，又是接收方
public class UdpTalkTest2 {
    public static void main(String[] args) throws IOException {
        new Thread(new UdpOnlineTalkSend(5555,"localhost",8888)).start();
        new Thread(new UdpOnlineTalkReceive(9999)).start();
    }
}
