package com.penruins.reflection.rpc.server;

public class HelloServiceImpl implements HelloService{
    @Override
    public void sayHi(String name) {
        System.out.println("hi" + name);
    }
}
