package com.penruins.socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 为每个客户分配一个线程
 */
public class EchoServer2 {
    private int port = 8000;
    private ServerSocket serverSocket;

    public EchoServer2() throws IOException {
        serverSocket = new ServerSocket(port);
        System.out.println("服务器启动");
    }

    public void service() {
        while(true) {
            Socket socket = null;
            try {
                socket = serverSocket.accept();
                Thread workThread = new Thread(new Handler(socket));
                workThread.start();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws IOException {
        new EchoServer2().service();
    }
}
class Handler implements Runnable {
    private Socket socket;
    public Handler(Socket socket) {
        this.socket = socket;
    }
    private PrintWriter getWriter(Socket socket) throws IOException{
        return new PrintWriter(socket.getOutputStream(),true);
    }
    private BufferedReader getReader(Socket socket) throws IOException{
        InputStream socketIn = socket.getInputStream();
        return new BufferedReader(new InputStreamReader(socketIn));
    }
    public String echo(String msg) {
        return "echo: " + msg;
    }

    @Override
    public void run() {
        try {
            System.out.println("New connection accepted " + socket.getInetAddress() + ":" + socket.getPort());
            BufferedReader br = getReader(socket);
            PrintWriter pw = getWriter(socket);

            String msg = null;
            while((msg=br.readLine()) != null) {
                System.out.println(msg);
                pw.println(echo(msg));
                if(msg.equals("bye")) break;
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (socket != null) socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
