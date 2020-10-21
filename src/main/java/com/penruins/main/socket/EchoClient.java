package com.penruins.main.socket;

import lombok.SneakyThrows;

import java.io.*;
import java.net.Socket;

public class EchoClient {
    private String host = "localhost";
    private int port = 8000;
    private Socket socket;

    @SneakyThrows
    public EchoClient() {
        socket = new Socket(host,port);
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
    public void talk() {
        BufferedReader br = getReader(socket);
        PrintWriter pw = getWriter(socket);
        BufferedReader localReader = new BufferedReader(new InputStreamReader(System.in));
        String msg = null;
        while((msg=localReader.readLine()) != null) {
            pw.println(msg);
            System.out.println(br.readLine());

            if(msg.equals("bye")) break;
        }
    }

    public static void main(String[] args) {
        new EchoClient().talk();
    }
}
