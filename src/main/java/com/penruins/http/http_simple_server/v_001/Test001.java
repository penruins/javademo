package com.penruins.http.http_simple_server.v_001;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;

/**
 * HttpServer是JDK 1.6 以后内置的一个轻量级HTTP服务器
 * 一个HTTPServer实例被绑定但一个IP地址和端口号，并监听来自该地址的客户端TCP连接。其子类HttpsServer实现实现了
 * HTTPS服务，还能处理HTTPS请求
 */
public class Test001 {
  public static void main(String[] args) throws Exception{
    //创建http服务器,绑定本地8080端口
    /**
     * HttpServer httpServer = HttpServer.create(InetSocketAddress addr, int backlog);
     *  addr 服务绑定的地址端口
     *  backlog TCP连接最大并发数，传 0 或 负数表示使用默认值
     */
    HttpServer httpServer = HttpServer.create(new InetSocketAddress(8080),0);

    //创上下文监听，"/" 表示匹配所有URL请求
    httpServer.createContext("/", new HttpHandler() {
      @Override
      public void handle(HttpExchange httpExchange) throws IOException {
        System.out.println("客户端IP地址： " + httpExchange.getRemoteAddress());
        System.out.println("请求协议：" + httpExchange.getProtocol());
        System.out.println("请求方法：" + httpExchange.getRequestMethod());
        System.out.println("请求URL："+ httpExchange.getRequestURI());

        //获取请求头
        String userAgent = httpExchange.getRequestHeaders().getFirst("User-Agent");
        System.out.println("User-Agent: " + userAgent);
        //响应内容
        byte[] respContents = "you dont give up then theres no limitation.".getBytes("UTF-8");
        //设置响应头
        httpExchange.getResponseHeaders().add("Content-Type","text/html;charset=UTF-8");
        //设置响应code和内容长度
        httpExchange.sendResponseHeaders(200,respContents.length);
        //设置响应内容
        httpExchange.getResponseBody().write(respContents);
        //关闭处理器
        httpExchange.close();

      }
    });

    // 创建上下文监听, 处理 URI 以 "/aa" 开头的请求
    httpServer.createContext("/aa", new HttpHandler() {
      @Override
      public void handle(HttpExchange httpExchange) throws IOException {
        byte[] respContents = "所有印象无不来自于感觉之中".getBytes("UTF-8");
        httpExchange.getResponseHeaders().add("Content-Type", "text/html; charset=UTF-8");
        httpExchange.sendResponseHeaders(200, respContents.length);
        httpExchange.getResponseBody().write(respContents);
        httpExchange.close();
      }
    });
    httpServer.start();
  }

}
