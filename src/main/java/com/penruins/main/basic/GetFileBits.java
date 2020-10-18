package com.penruins.main.basic;


import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * 获取远程文件大小
 */
public class GetFileBits {
    public static void main(String[] args) throws IOException {
        int size;
        URL url = new URL("http://www.runoob.com/wp-content/themes/runoob/assets/img/newlogo.png");
        URLConnection conn = url.openConnection();
        size = conn.getContentLength();
        if(size < 0)
            System.out.println("无法获取文件大小");
        else
            System.out.println("文件大小为： " + size + " bytes");
        conn.getInputStream().close();
    }
}
