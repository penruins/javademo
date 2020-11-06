package com.penruins.design_pattern.singletonPattern;

/**
 * 饿汉式单例在类初始化已经实例化
 * 线程安全
 */
public class Singleton_hunger {
    private static final Singleton_hunger mInstance = new Singleton_hunger();

    private Singleton_hunger() {

    }

    public static Singleton_hunger getInstance() {
        return mInstance;
    }
}
