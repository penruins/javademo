package com.penruins.http.http_simple_server;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * 实现了多线程访问
 *    缺点：是阻塞式的，每个访问都要启用一个线程，没有数据输入线程就会阻塞，线程重复创建和销毁
 */
public class HttpSimpleServer3 {
  public void startServer() throws IOException {
    ServerSocket serverSocket = new ServerSocket(10021);
    while(true) {
      Socket socket = serverSocket.accept();
      Runnable runnable = new Runner(socket);
      Thread thread = new Thread(runnable);
      thread.start();
    }
  }

  public static void main(String[] args) throws IOException {
    new HttpSimpleServer3().startServer();
  }
}

class Runner implements Runnable {
  private final Socket socket;

  public Runner(Socket socket) {
    this.socket = socket;
  }

  @Override
  public void run() {
    try {
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
      printWriter.flush();

    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
