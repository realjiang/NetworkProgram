package com.superj.port;

import java.net.InetSocketAddress;

public class TestInetSocketAddress {
    public static void main(String[] args) {
        InetSocketAddress inetSocketAddress1 = new InetSocketAddress("127.0.0.1",8080);
        System.out.println(inetSocketAddress1);
        InetSocketAddress inetSocketAddress2 = new InetSocketAddress("localhost",8080);
        System.out.println(inetSocketAddress2);

        System.out.println(inetSocketAddress1.getAddress());//地址
        System.out.println(inetSocketAddress1.getHostName());//主机名
        System.out.println(inetSocketAddress1.getHostString());//主机名
        System.out.println(inetSocketAddress1.getPort());//端口号
    }
}
