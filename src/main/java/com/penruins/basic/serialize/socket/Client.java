package com.penruins.basic.serialize.socket;

import lombok.SneakyThrows;

import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.net.Socket;

public class Client {
    @SneakyThrows
    public static void main(String[] args) {
        Socket socket = new Socket("localhost",8080);
        ObjectInput objectInput = new ObjectInputStream(socket.getInputStream());
        UserInfo userInfo = (UserInfo) objectInput.readObject();
        objectInput.close();
        System.out.println(userInfo);
        socket.close();
    }
}
