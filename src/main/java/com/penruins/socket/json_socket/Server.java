package com.penruins.socket.json_socket;


import net.sf.json.JSONObject;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
  public static void main(String[] args) throws Exception{
    ServerSocket serverSocket = new ServerSocket(8000);
    System.out.println("服务器启动");
    Socket socket = serverSocket.accept();
    System.out.println("New connectioin accepted " + socket.getInetAddress() + ":" + socket.getPort());
    BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
    String msg = br.readLine();
    System.out.println(msg);
    JSONObject jsonObject = JSONObject.fromObject(msg);
    User user = (User) JSONObject.toBean(jsonObject,User.class);
    System.out.println(user);

  }
}
