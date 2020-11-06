package com.penruins.http.http_simple_server;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;


/**
 * 使用while循环持续监听client连接
 *
 * 缺点：仍旧不能多线程访问
 */
public class HttpSimpleServer2 {
  public void startServer() throws IOException {
    ServerSocket serverSocket = new ServerSocket(10021);
    while(true) {
      Socket socket = serverSocket.accept();
      InputStream in = socket.getInputStream();//获取输入流
      PrintWriter printWriter = new PrintWriter(socket.getOutputStream(), true);//获取输出流
      Scanner scanner = new Scanner(in);
      scanner.useDelimiter("\r\n\r\n");
      if (scanner.hasNext()) {
        String header = scanner.next();
        System.out.println(header);
      }
      printWriter.print("HTTP/1.0 200 OK\r\n");
      printWriter.print("Content-type:text/html; charset=utf-8\r\n");
      printWriter.print("\r\n");
      printWriter.println("<font color='red' size='7'>今天天气真好</font>");

      scanner.close();
      socket.close();
    }
  }

  public static void main(String[] args) throws IOException {
    new HttpSimpleServer2().startServer();
  }
}
