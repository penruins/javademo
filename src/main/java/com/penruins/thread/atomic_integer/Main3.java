package com.penruins.thread.atomic_integer;

import java.util.concurrent.atomic.AtomicInteger;

public class Main3 {
    private static final int THREADS_COUNT = 20;
    public static AtomicInteger count = new AtomicInteger();

    public static void increase() {
        count.incrementAndGet();
    }

    /**
     * 将上面的代码改造成AtomicInteger
     * @param args
     */
    public static void main(String[] args) {
        Thread[] threads = new Thread[THREADS_COUNT];
        for(int i=0;i<THREADS_COUNT;i++) {
            threads[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    for(int i=0;i<10000;i++) {
                        increase();
                    }
                }
            });
            threads[i].start();
        }
        while(Thread.activeCount() > 1) {
            Thread.yield();
        }
        System.out.println(count);
    }
}
/**
 * 同步：多线程并发访问共享数据时，保证共享数据在同一时刻只被一个或一些线程使用
 */
