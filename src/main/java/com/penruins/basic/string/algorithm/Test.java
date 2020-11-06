package com.penruins.basic.string.algorithm;

public class Test {

    @org.junit.Test
    public void test1() {
        System.out.println(Main.onlyOnceString("Don't to gentle into that good night!",'o'));
        System.out.println(Main.onlyOnceString("Don't to gentle into that good night!",'!'));
        System.out.println(Main.reverseString("aabbccddeeffgg"));
        System.out.println(Main.toUpperCase("aabbccddeeffgg"));
    }
}
