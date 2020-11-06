package com.penruins.bitset;

import org.junit.Test;

import java.util.BitSet;

public class Util {
  /**
   *  求一个字符串包含的char
   */
  public static  void containChars(String str) {
    BitSet used = new BitSet();
    for(int i=0;i<str.length();i++) {
      used.set(str.charAt(i)); //set bit for char
    }
    StringBuilder sb = new StringBuilder();
    sb.append("[");
    int size = used.size();
    System.out.println(size);
    for(int i=0;i<size;i++) {
      if(used.get(i)) {
        sb.append((char) i);
      }
    }
    sb.append("]");
    System.out.println(sb.toString());
  }
}
