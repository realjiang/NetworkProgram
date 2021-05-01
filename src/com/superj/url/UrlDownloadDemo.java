package com.superj.url;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

//根据url下载资源
public class UrlDownloadDemo {
    public static void main(String[] args) throws Exception {
        //1 下载地址
        URL url = new URL("http://localhost:9090/superj/oops.html");
        //2 连接到这个资源 HTTP
        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
        //3 下载资源 流
        InputStream is = urlConnection.getInputStream();
        FileOutputStream fos = new FileOutputStream("oops.html");

        byte[] buffer = new byte[1024];
        int len;
        while ((len = is.read(buffer)) != -1) {
            fos.write(buffer,0,buffer.length);
        }
        fos.close();
        is.close();
        urlConnection.disconnect();//断开连接
    }
}
