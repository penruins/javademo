package com.penruins.socket.json_socket;

import com.penruins.json.Address;
import com.penruins.json.Person;
import lombok.SneakyThrows;
import org.json.JSONObject;

import java.io.*;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost",8000);
        PrintWriter printWriter = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()),true);
        User user = new User("penruins","mzrfviwhninayh",21);
        System.out.println("初始化了一个java bean 对象");
        System.out.println(user);
        System.out.println("将 java bean 转换为 JSON 数据的格式");
        JSONObject jsonObject = new JSONObject(user);
        String jsonData = jsonObject.toString();
        System.out.println(jsonData);
        printWriter.println(jsonData);
    }
}




















