package com.penruins.socket.v_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Server {
    private List<ThreadServer> clients=new ArrayList<ThreadServer>();
    
    public void startup() throws IOException {
        System.out.println("监听5001端口");
        ServerSocket ss=new ServerSocket(5001);
        while(true){
            Socket socket=ss.accept();
            System.out.println("发现新用户");
            Thread st=new Thread(new ThreadServer(socket));
            st.start();
        }
    }
    
    public class ThreadServer implements Runnable{
        private Socket socket;
        private BufferedReader br;
        private PrintWriter out;
        private String name;
        private Boolean flag=true;
        public ThreadServer(Socket socket) throws IOException {
            this.socket=socket;
            br=new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out=new PrintWriter(socket.getOutputStream(),true);
            String str=br.readLine();
            name=str+"["+socket.getInetAddress().getHostAddress()+":"+socket.getPort()+"]";
            System.out.println(name+"加入该聊天室");
            send(name+"加入该聊天室");
            clients.add(this);
        }
        private void send(String message) {
            for (ThreadServer threadServer : clients) {
                System.out.println("-->已向线程"+threadServer.name+"发送消息");
                threadServer.out.print(message);
                threadServer.out.flush();
            }
        }
        private void receive() throws IOException {
            String message;
            while(flag) {
                message=br.readLine();
                if(message.equalsIgnoreCase("quit")) {
                    System.out.println("用户"+name+"退出了");
                    out.println("quit");
                    out.flush();
                    clients.remove(this);
                    flag=false;
                }
                System.out.println(name+":"+message);
                send(name+":"+message);
            }
        }
        @Override
        public void run() {
            try {
                while(flag=true) {
                    receive();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }finally {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    
    public static void main(String []args) throws IOException {
        Server server=new Server();
        System.out.println("服务器开启");
        server.startup();
    }
    
}