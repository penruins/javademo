package com.penruins.proxy.dynamic_proxy.handler;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 必须完成InvocationHandler接口，完成代理类要做的功能
 *    1. 调用目标方法
 *    2. 功能增强
 */
public class MySellHandler implements InvocationHandler {
  //目标对象
  private Object target = null;

  /**
   * 动态代理：目标对象是活动的，不是固定的，需要传入进来。你传入的是谁，就给谁创建代理
   * @param target
   */
  public MySellHandler(Object target) {
    this.target = target;
  }

  @Override
  public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
    Object res = null;
    res = method.invoke(target,args);//执行目标方法
    if(res != null) {
      Float price = (Float) res;
      price += 25;
      res = price;
    }
    return res;
  }
}
