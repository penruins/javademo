package com.penruins.main.reflection.rpc.server;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.util.HashMap;

public class ServerCenter implements Server{
    /**
     * map 服务端的所有可供客户端访问的接口
     * 都注册到该map中
     *
     * key 接口的名字
     * value 真正的实现
     */
    private static HashMap<String,Class> serviceRegister = new HashMap();
    private int port;

    public ServerCenter(int port) {
        this.port = port;
    }

    /**
     * 开启服务端服务
     */
    @Override
    public void start() {
        ServerSocket server = null;
        try {
            server = new ServerSocket();
            server.bind(new InetSocketAddress(port));
            server.accept();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void stop() {

    }

    @Override
    public void register(Class service, Class serviceImpl) {
        serviceRegister.put(service.getName(),serviceImpl);
    }


}
