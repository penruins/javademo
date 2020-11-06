package com.penruins.proxy.static_proxy.review;

public class HelloServiceImpl implements HelloSErvice{
  @Override
  public void sayHello(String name) {
    System.out.println("你好：" + name);
  }

}
