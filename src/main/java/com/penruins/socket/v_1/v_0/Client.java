package com.penruins.socket.v_1.v_0;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {
    private PrintWriter out;
    private Scanner scan;
    private Boolean flag=true;
    private Socket s;
    private InputStream is;
    
    public static void main(String []args) throws UnknownHostException, IOException {
        new Client().startup();
    }
    public void startup() throws UnknownHostException, IOException {
        scan = new Scanner(System.in);
        s=new Socket("127.0.0.1", 5001);
        is=s.getInputStream();
        out = new PrintWriter(s.getOutputStream(), true);

        //开启一个线程监听服务端的消息
        new Thread(new Runnable() {
            @Override
            public void run() {
                while(true) {
                    try {
                        byte ss[]=new byte[1024];
                        int length=s.getInputStream().read(ss);
                        System.out.println(new String(ss,0,length));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
        //主线程负责发送消息
        while(flag) {
            String read=scan.nextLine();
            out.println(read);
        }
        s.close();
    }
}