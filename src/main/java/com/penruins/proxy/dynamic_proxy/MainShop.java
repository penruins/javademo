package com.penruins.proxy.dynamic_proxy;


import com.penruins.proxy.dynamic_proxy.factory.USBKingFactory;
import com.penruins.proxy.dynamic_proxy.handler.MySellHandler;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class MainShop {
  public static void main(String[] args) {
    USBKingFactory usbKingFactory =new USBKingFactory();//创建目标对象
    InvocationHandler handler = new MySellHandler(usbKingFactory);//创建InvocationHandler对象
    //创建代理对象，使用Proxy
    USBSell proxy = (USBSell) Proxy.newProxyInstance(usbKingFactory.getClass().getClassLoader(),usbKingFactory.getClass().getInterfaces(),handler);
    float price = proxy.sell(1);//通过代理执行方法
    System.out.println("通过动态代理对象，调用方法： " + price);
  }
}
