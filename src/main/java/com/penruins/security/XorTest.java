package com.penruins.security;

import org.junit.Test;

/**
 * 异或 同为0 异为1
 *      一个数 两次异或之后，是原数本身
 */
public class XorTest {

  public String xor(String input) {
    char[] chs = input.toCharArray();
    for(int i=0;i<chs.length;i++) {
      chs[i] = (char) (chs[i]^3000);
    }
    return new String(chs);
  }

  @Test
  public void test() {
    String str = "hello";
    str = xor(str); //加密
    System.out.println(str);
    str = xor(str); //解密
    System.out.println(str);
  }
}
