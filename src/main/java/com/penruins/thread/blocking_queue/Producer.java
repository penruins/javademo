package com.penruins.thread.blocking_queue;

import java.util.Random;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class Producer implements Runnable{
    private volatile boolean isRunning = true;
    private BlockingDeque queue;
    private static AtomicInteger count = new AtomicInteger();
    private static final int DEFAULT_RANGE_FOR_SLEEP = 1000;

    public Producer(BlockingDeque queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        String data = null;
        Random r = new Random();

        System.out.println("启动生产者线程!");
        try {
            System.out.println("正在生产数据");
            Thread.sleep(r.nextInt(DEFAULT_RANGE_FOR_SLEEP));
            data = "data:" + count.incrementAndGet();
            System.out.println("将数据： " + data + " 放入队列...");
            if(!queue.offer(data,2, TimeUnit.SECONDS)) {
                System.out.println("放入数据失败：" + data);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
            Thread.currentThread().interrupt();
        } finally {
            System.out.println("退出生产者线程!");
        }
    }

    public void stop() {
        isRunning = false;
    }
}
