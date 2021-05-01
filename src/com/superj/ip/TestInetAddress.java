package com.superj.ip;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class TestInetAddress {
    public static void main(String[] args) {
        try {
            //查询本机地址
            InetAddress inetAddress1 = InetAddress.getByName("172.0.0.1");
            System.out.println(inetAddress1);
            InetAddress inetAddress2 = InetAddress.getByName("localhost");
            System.out.println(inetAddress2);
            InetAddress inetAddress3 = InetAddress.getLocalHost();
            System.out.println(inetAddress3);
            //查询网站ip地址
            InetAddress inetAddress4 = InetAddress.getByName("www.baidu.com");
            System.out.println(inetAddress4);
            //常用方法
            //System.out.println(inetAddress4.getAddress());//字节数组，返回一组地址，很少用
            System.out.println(inetAddress4.getCanonicalHostName());//规范的名字-ip，很少用
            System.out.println(inetAddress4.getHostAddress());//主机地址-ip
            System.out.println(inetAddress4.getHostName());//主机名字-域名

        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}
