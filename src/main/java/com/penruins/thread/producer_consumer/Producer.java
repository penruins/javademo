package com.penruins.thread.producer_consumer;


import java.util.concurrent.BlockingDeque;
import java.util.concurrent.atomic.AtomicInteger;

public class Producer {
    /**
     * 可见性，是指线程之间的可见性，一个线程修改的状态对另一个线程是可见的。
     * 也就是一个线程修改的结果。另一个线程马上就能看到
     *
     * 比如用volatile修饰的变量，就会具有可见性。
     * volatile修饰的变量不允许线程内部缓存和重排序
     * 即直接修改内存。所以对其他线程是可见的
     *
     * 但是这里需要注意一个问题，volatile只能让被他修饰内容具有可见性
     * 但不能保证它具有原子性
     * 比如 volatile int a = 0;
     * 之后有一个操作a++
     * 这个变量a具有可见性，但是a++依然是一个非原子操作
     * 也就是这个操作同样存在线程安全问题
     */
    private volatile boolean isRunning = true;
    private BlockingDeque<PCData> queue;
    private static AtomicInteger count = new AtomicInteger();
    private static final int SLEEPTIME = 1000;
}
