package com.penruins.thread.atomic_integer;

public class Main {
    private static final int THREADS_COUNT = 20;
    public static int count = 0;

    public static void increase() {
        count++;
    }

    /**
     * 这里运行了20个线程，每个线程对count变量进行10000次自增操作
     * 如果上面的代码能够正常并发的话，最后的结果应该是200000才对
     * 但实际结果却发现每次运行的结果都不相同，都是小于200000的数字
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
