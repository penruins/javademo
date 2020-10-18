package com.penruins.main.design_pattern.singletonPattern;

import org.junit.Test;

/**
 * 懒汉式单例在第一次调用的时候初始化
 * 懒汉式单例是线程不安全的，在并发的情况下，可能出现多个Singleton实例
 * 要实现线程安全需要对getInstance() 进行改造，以确保线程安全
 */
public class Singleton_lazy {
    private static Singleton_lazy mSingleton_lazy;

    /**
     * 通过将构造方法限定为private避免了类在外部被实例化
     * 在同一个虚拟机范围内，Singleton的唯一实例只能通过getInstance()方法访问
     *      事实上，通过java反射机制是能够实例化构造方法为private的类的，那基本上会使所有的java单例实现失效。
     *      此问题在此处不作讨论
     *
     */
    private Singleton_lazy() {

    }

    public static Singleton_lazy getInstance() {
        if(mSingleton_lazy == null)
            mSingleton_lazy = new Singleton_lazy();
        return mSingleton_lazy;
    }

    /**
     * 第一种改造方案： 将方法设为同步
     */
    public synchronized static Singleton_lazy getInstance1() {
        if(mSingleton_lazy == null)
            mSingleton_lazy = new Singleton_lazy();
        return mSingleton_lazy;
    }


    /**
     * 第二种改造方案：双重检查锁定 (比第一种效率要高）
     */
    public static Singleton_lazy getInstance2() {
        if(mSingleton_lazy == null) {
            synchronized (Singleton_lazy.class) {
                if (mSingleton_lazy == null) {
                    mSingleton_lazy = new Singleton_lazy();
                }
            }
        }
        return mSingleton_lazy;
    }

    /**
     * 第三种方式： 静态内部类
     * 这种比上面1、2都好一些，既实现了线程安全，又避免了同步带来的性能影响
     */
    public static Singleton_lazy getInstance3() {
        return LazyHolder.instance;
    }
    private static class LazyHolder {
        private static final Singleton_lazy instance = new Singleton_lazy();
    }

}





















