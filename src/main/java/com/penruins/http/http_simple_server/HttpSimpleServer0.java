package com.penruins.http.http_simple_server;


import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 基于Java的Http服务器
 *
 * 这是一个错误版本
 *
 * 浏览器在等待你的响应，所以我们需要自己界定请求头的范围。请求头的结束标志是两个连续的换行\r\n\r\n
 */
public class HttpSimpleServer0 {
  public void startServer() throws IOException {
    ServerSocket ss = new ServerSocket(10021);
    Socket socket = ss.accept();
    InputStream in = socket.getInputStream();
    PrintWriter pw = new PrintWriter(socket.getOutputStream(),true);
    byte[] buf = new byte[1024];
    int len = -1;
    while((len=in.read(buf))!=-1) {
      String str = new String(buf,0,len);
//      if(str.trim().length() <=0) break;
      System.out.println(str);
    }
    pw.println("<font color='red' size='7'>今天天气真好</font>");
    socket.close();
    ss.close();
  }
  public static void main(String[] args) throws IOException {
    new HttpSimpleServer0().startServer();
  }
}
