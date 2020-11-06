package com.penruins.http.http_simple_server;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * 浏览器和你的http服务器建立连接后，先发送请求头信息，然后并不会断开连接，所以read方法就会一直阻塞，等待服务器关闭连接（只有关闭后才会返回-1）
 * TCP断开连接使用的是四次分手原则，之所以使用四次分手原则，是因为TCP是全双工的管道，
 *
 * HTTP的TCP连接的主动关闭方一般是服务端，是在服务端的Response通过TCP发送出去之后再调用socket.close()方法的
 *
 *
 * 浏览器正在等待你的响应，所以我们需要自己界定请求头的范围。请求头的结束标志是两个连续的换行\r\n\r\n
 *
 * 还有问题就是返回信息没有HTTP响应头部，可能会出现乱码或者浏览器无法识别等问题
 *
 * 缺点：
 *    不能多线程访问
 *    只能访问一次，程序就运行结束了
 *
 */
public class HttpSimpleServer1 {
  public void startServer() throws IOException {
    ServerSocket serverSocket = new ServerSocket(10021);
    Socket socket = serverSocket.accept();
    InputStream in = socket.getInputStream();//获取输入流
    PrintWriter printWriter = new PrintWriter(socket.getOutputStream(),true);//获取输出流
    Scanner scanner = new Scanner(in);
    scanner.useDelimiter("\r\n\r\n");
    if(scanner.hasNext()) {
      String header = scanner.next();
      System.out.println(header);
    }
    printWriter.print("HTTP/1.0 200 OK\r\n");
    printWriter.print("Content-type:text/html; charset=utf-8\r\n");
    printWriter.print("\r\n");
    printWriter.println("<font color='red' size='7'>今天天气真好</font>");

    scanner.close();
    socket.close();
    serverSocket.close();
  }

  public static void main(String[] args) throws IOException {
    new HttpSimpleServer1().startServer();
  }
}
