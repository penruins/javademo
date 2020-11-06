package com.penruins.socket.v_1;

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
    
    public Client() throws UnknownHostException, IOException {
        s=new Socket("127.0.0.1", 5001);
        is=s.getInputStream();
        out = new PrintWriter(s.getOutputStream(), true);
    }
    
    public static void main(String []args) throws UnknownHostException, IOException {
        Client client =new Client();
        client.startup();
    }
    public void startup() throws UnknownHostException, IOException {

        //开启一个线程监听服务端的消息
        Thread ct=new Thread(new Runnable() {
            @Override
            public void run() {
                while(true) {
                    if(!flag) break;
                    try {
                        receive();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        ct.start();
        //主线程负责发送消息
        System.out.println("请输入你的用户名：");
        scan = new Scanner(System.in);
        String name=scan.nextLine();
        out.println(name);
        System.out.println(name+",欢迎进入聊天室，输入quit退出");
        while(flag) {
            String read=scan.nextLine();
            if(read.equalsIgnoreCase("quit")) {
                flag=false;
            }
            out.println(read);
        }
        s.close();
    }
    
    public void receive() throws IOException {
        byte ss[]=new byte[1024];
        int length=s.getInputStream().read(ss);
        System.out.println(new String(ss,0,length));
    }
}