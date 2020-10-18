package com.penruins.main.dynamic_programming;

import org.junit.Test;

/**
 * 动态规划是一种编程原理，可以通过将非常复杂的问题划分为更小的子问题来解决。
 * 这个原则与递归很类似，但是与递归有一个关键的不同，就是每个不同的子问题只能被解决一次
 */
public class Main {
    //递归版
    public static int fibonacci(int n) {
        if(n==1 || n==2) return 1;
        return fibonacci(n-1) + fibonacci(n-2);
    }

    //动态规划版
    public static int fibonacci2(int n) {
        int a[] = new int[1024];
        a[0] = 0;
        a[1] = 1;
        for(int i=2;i<=n;i++) {
            a[i] = a[i-1] + a[i-2];
        }
        return a[n];
    }

    @Test
    public void test() {
        System.out.println(fibonacci(10));
        System.out.println(fibonacci(33));
        System.out.println(fibonacci2(10));
        System.out.println(fibonacci2(33));
    }
}
