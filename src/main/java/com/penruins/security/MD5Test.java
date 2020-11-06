package com.penruins.security;


import org.apache.commons.codec.digest.DigestUtils;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * MD5/SHA256
 *  不可逆
 *
 *  MD5 不可逆 速度较快
 *  SHA256 不可逆 安全性较高
 */
public class MD5Test {
  public String md5Encript(byte[] input) {
    return DigestUtils.md5Hex(input);
  }

  public static String sha256Encript(byte[] input) {
    return DigestUtils.sha256Hex(input);
  }

  /**
   * Base64加密
   */
  public static String base64Encode(byte[] input) {
    String result = null;
    try {
      Class clazz = Class.forName("com.sun.org.apache.xerces.internal.impl.dv.util.Base64");
      Method method = clazz.getMethod("encode",byte[].class);
      result = (String) method.invoke(null,input); //静态方法不需要写对象
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    } catch (NoSuchMethodException e) {
      e.printStackTrace();
    } catch (IllegalAccessException e) {
      e.printStackTrace();
    } catch (InvocationTargetException e) {
      e.printStackTrace();
    }
    return result;
  }

  /**
   * Base64解密
   */
  public byte[] base64Decode(String input) {
    byte[] result = null;
    try {
      Class clazz = Class.forName("com.sun.org.apache.xerces.internal.impl.dv.util.Base64");
      Method method = clazz.getMethod("decode",String.class);
      result = (byte[]) method.invoke(null,input);
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    } catch (NoSuchMethodException e) {
      e.printStackTrace();
    } catch (IllegalAccessException e) {
      e.printStackTrace();
    } catch (InvocationTargetException e) {
      e.printStackTrace();
    }
    return result;
  }



  /**
   * MD5加密测试
   */
  @Test
  public void test() {
    String str = "hello world";
    str = md5Encript(str.getBytes());
    System.out.println(str);
  }

  /**
   * sha加密测试
   */
  @Test
  public void test2() {
    String str = "hello world";
    str = sha256Encript(str.getBytes());
    System.out.println(str);
  }

  /**
   * base64加密解密测试
   */
  @Test
  public void test3() {
    String str = "hello world";
    str = base64Encode(str.getBytes());
    System.out.println(str);
    byte[] strBytes = base64Decode(str);
    System.out.println(new String(strBytes));
  }

}
