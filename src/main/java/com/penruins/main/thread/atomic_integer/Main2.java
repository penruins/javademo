package com.penruins.main.thread.atomic_integer;

public class Main2 {
    private static final int THREADS_COUNT = 20;
    public static volatile int count = 0;

    public static void increase() {
        count++;
    }

    /**
     * 将全局变量换成volatile
     *
     * volatile关键字很重要的两个特性
     *      保证变量在线程间可见，对volatile变量所有的写操作
     *      都能立即反应到其他线程中，换句话说，volatile变量
     *      在各个线程中是一致的
     *
     *      禁止指令的重排序优化
     * @param args
     */


    /**
     * 但结果仍然是不正确的
     * 因为java里的运算（比如自增）并不是原子性的
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
