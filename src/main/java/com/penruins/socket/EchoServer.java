package com.penruins.socket;

import lombok.SneakyThrows;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 本书介绍的Java网络程序都建立在TCP/IP协议基础上，致力于实现应用层。传输层向应用层提供了套接字Socket接口
 * Socket封装了下层的数据传输细节，应用层的程序通过Socket来建立与远程主机的连接，以及进行数据传输
 *
 * 站在应用层的角度，两个进程之间的一次通信过程从建立连接开始
 * 接着交换数据，到断开连接结束
 *
 * 套接字可看作是通信线路两端的收发器，进程通过套接字来收发数据
 *
 * 在Java中，有三种套接字类
 *      java.net.Socket
 *      java.net.ServerSocket
 *      java.net.DatagramSocket
 *      其中前两种建立在TCP协议基础上，DatagramSocket类建立在UDP协议基础上
 *
 * Java网络程序都采用客户/服务器通信模式
 */
public class EchoServer {

    /**
     * ServerSocket的构造方法负责在操作系统中把当前进程注册为服务器进程。
     * 服务器程序接下来调用ServerSocket对象的accept()方法，该方法一直监听端口，等待客户的连接请求
     * 如果接收到一个车连接请求，accept()方法就会返回一个Socket对象，这个Socket对象与客户端的Socket对象
     * 形成了一条通信线路
     *
     * Socket类提供了getInputStream()方法和getOutputStream()方法，分别返回输入流InputStream对象和输出流
     * OutputStream对象。程序只需向输出流写数据，就能向对方发送数据；只需从输入流读数据，就能接收来自对方的数据
     *
     * 与普通I/O流一样，Socket的输入流和输出流也可以用过滤流来装饰。在一下代码中，先获得输出流，然后用PrintWriter装饰它
     * PrintWriter的println()方法能够写一行数据；
     * 输入流用BufferedReader装饰它，BufferedReader的readLine()方法能够读入一行数据
     */

    private int port = 8000;
    private ServerSocket serverSocket;

    @SneakyThrows
    public EchoServer() {
        serverSocket = new ServerSocket(port);
        System.out.println("服务器启动");
    }

    public String echo(String msg) {
        return "echo: " + msg;
    }

    @SneakyThrows
    private PrintWriter getWriter(Socket socket) {
        OutputStream socketOut = socket.getOutputStream();
        return new PrintWriter(socketOut,true);
    }
    @SneakyThrows
    private BufferedReader getReader(Socket socket) {
        InputStream socketIn = socket.getInputStream();
        return new BufferedReader(new InputStreamReader(socketIn));
    }

    @SneakyThrows
    public void service() {
        while(true) {
            Socket socket = serverSocket.accept();
            System.out.println("New connectioin accepted " + socket.getInetAddress() + ":" + socket.getPort());
            BufferedReader br = getReader(socket);
            PrintWriter pw = getWriter(socket);

            String msg = null;
            while((msg=br.readLine()) != null) {
                System.out.println(msg);
                pw.println(echo(msg));
                if(msg.equals("bye")) {
                    break;
                }
            }
        }

    }


    @SneakyThrows
    public static void main(String[] args) {

        new EchoServer().service();

    }
}























