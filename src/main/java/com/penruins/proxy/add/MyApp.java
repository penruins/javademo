package com.penruins.proxy.add;

import com.penruins.proxy.add.handler.MyInvocationHandler;
import com.penruins.proxy.add.service.Func;
import com.penruins.proxy.add.service.HelloService;
import org.junit.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class MyApp {

  @Test
  public void test() {
    Func func = new Func();
    int num = func.print("penruins");
    System.out.println(num);
  }

  @Test
  public void test2() {
    Func func = new Func();
    InvocationHandler handler = new MyInvocationHandler(func);
    HelloService proxy = (HelloService) Proxy.newProxyInstance(func.getClass().getClassLoader(),func.getClass().getInterfaces(),handler);
    int num = proxy.print("penruins");
    System.out.println(num);
  }
}
