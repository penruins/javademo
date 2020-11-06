package com.penruins.proxy.static_proxy.review;

import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 反射机制复习
 *    Method类，表示方法。类中的方法。通过Method可以执行某个方法
 */
public class ReflectReviewTest {
  @Test
  public void test() {
    HelloSErvice sErvice = new HelloServiceImpl();
    sErvice.sayHello("penruins");
  }

  /**
   * 使用反射机制执行sayHello方法
   */
  @Test
  public void test2() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
    HelloSErvice sErvice = new HelloServiceImpl();
    Method method = HelloSErvice.class.getMethod("sayHello", String.class);
    Object ret = method.invoke(sErvice,"penruins");
  }

}
