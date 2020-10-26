package com.penruins.rpc.rpc03;

import com.penruins.rpc.common.IUserService;
import com.penruins.rpc.common.User;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private static boolean running = true;
    public static void main(String[] args) throws IOException {
        ServerSocket ss = null;
        ss = new ServerSocket(8888);
        while (running) {
            Socket s = ss.accept();
            process(s);
            s.close();
        }

    }

    /**
     * client发送一个ID，我回复对应id的信息
     * @param s
     * @throws IOException
     */
    private static void process(Socket s) throws IOException {
        InputStream in = s.getInputStream();
        OutputStream out = s.getOutputStream();
        DataInputStream dis = new DataInputStream(in);
        DataOutputStream dos = new DataOutputStream(out);
        int id = dis.readInt();
        IUserService service = new UserServiceImpl();
        User user = service.findUserByID(id);
        dos.writeInt(user.getId());
        dos.writeUTF(user.getName());
        dos.flush();
    }
}
