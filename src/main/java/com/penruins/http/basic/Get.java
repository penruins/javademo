package com.penruins.http.basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 *  编写一个java application
 *  完成以下功能： 此程序可以建立HTTP通信，以GET方式向WEB服务器提交信息，并接收WEB服务器返回的响应
 *
 *
 */
public class Get {
  public static void main(String[] args) {
    new ReadByGet().start();
  }

  static class ReadByGet extends Thread {
    @Override
    public void run() {
      try {
        URL url = new URL("https://www.youku.com");
        URLConnection connection = url.openConnection();
        InputStream is = connection.getInputStream();
        InputStreamReader isr = new InputStreamReader(is,"utf-8");
        BufferedReader br = new BufferedReader(isr);
        String line = null;
        StringBuilder builder = new StringBuilder();
        while((line=br.readLine()) != null) {
          builder.append(line+"\n");
        }
        br.close();
        isr.close();
        is.close();
        System.out.println(builder);
      } catch (MalformedURLException e) {
        e.printStackTrace();
      } catch (IOException e) {
        e.printStackTrace();
      }
    }



  }
}
