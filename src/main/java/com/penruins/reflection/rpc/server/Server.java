package com.penruins.reflection.rpc.server;

/**
 * 服务中心
 *
 */
public interface Server {
    void start();
    void stop();
    //注册服务
    void register(Class service,Class serviceImpl);
}
