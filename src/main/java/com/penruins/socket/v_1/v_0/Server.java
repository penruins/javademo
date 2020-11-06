package com.penruins.socket.v_1.v_0;

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
        ServerSocket ss=new ServerSocket(5001);
        while(true){
            Socket socket=ss.accept();
            Thread st=new Thread(new ThreadServer(socket));
            st.start();
        }
    }
    
    public class ThreadServer implements Runnable{
        private Socket socket;
        private BufferedReader br;
        private PrintWriter out;
        private Boolean flag=true;
        public ThreadServer(Socket socket) throws IOException {
            this.socket=socket;
            br=new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out=new PrintWriter(socket.getOutputStream(),true);
            String str=br.readLine();
            clients.add(this);
        }
        private void send(String message) {
            for (ThreadServer threadServer : clients) {
                threadServer.out.print(message);
                threadServer.out.flush();
            }
        }
        private void receive() throws IOException {
            String message;
            while(flag) {
                message=br.readLine();
                if(message.equalsIgnoreCase("quit")) {
                    out.println("quit");
                    out.flush();
                    clients.remove(this);
                    flag=false;
                }
                send(message);
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
        new Server().startup();
    }
    
}