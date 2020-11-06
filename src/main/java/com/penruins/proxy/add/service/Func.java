package com.penruins.proxy.add.service;

public class Func implements HelloService{
  @Override
  public int print(String name) {
    System.out.println("其他人写好的功能方法");
    return 2;
  }
}
