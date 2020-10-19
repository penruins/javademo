package com.penruins.main.basic.serialize.socket;

import lombok.SneakyThrows;

import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    @SneakyThrows
    public static void main(String[] args) {
        ServerSocket serverSocket = new ServerSocket(8080);
        Socket socket = serverSocket.accept();
        ObjectOutput objectOutput = new ObjectOutputStream(socket.getOutputStream());
        UserInfo userInfo = new UserInfo();
        userInfo.setAge(12);
        userInfo.setName("Tom");

        objectOutput.writeObject(userInfo);
        objectOutput.flush();
        objectOutput.close();
        serverSocket.close();
    }
}
