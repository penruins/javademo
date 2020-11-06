package com.penruins.design_pattern.singletonPattern;

import org.junit.Test;

public class SingletonTest {
    @Test
    public void test() {
        Singleton_lazy singleton_lazy = Singleton_lazy.getInstance();
        Singleton_lazy singleton_lazy1 = Singleton_lazy.getInstance1();
        Singleton_lazy singleton_lazy2 = Singleton_lazy.getInstance2();
        Singleton_lazy singleton_lazy3 = Singleton_lazy.getInstance3();
        System.out.println(singleton_lazy == singleton_lazy1);
        System.out.println(singleton_lazy == singleton_lazy2);
        System.out.println(singleton_lazy == singleton_lazy3);
    }

    @Test
    public void test2() {
        Singleton_hunger singleton_hunger = Singleton_hunger.getInstance();
        Singleton_hunger singleton_hunger1 = Singleton_hunger.getInstance();
        System.out.println(singleton_hunger == singleton_hunger1);
    }
}
