package com.penruins.main.thread;


import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * 线程池的工作机制：
 *      在线程池的编程模式下，任务是提交给整个线程池，而不是直接提交给某个线程，线程池在拿到任务后，就在内部寻找是否有空闲的线程
 *      如果有，则将任务交给某个空闲的线程
 *
 *      一个线程同时只能执行一个任务，但可以同时向一个线程池提交多个任务
 */
public class Main {

    /**
     * ExecutorService
     * 是java提供的管理线程池的类。该类的两个作用：控制线程数量和重用线程
     *
     * Executor.newCacheThreadPool() 可缓存线程池
     * 先查看池中有没有以前建立的线程，如果有，就直接使用。如果没有，就建一个新的线程加入池中
     * 缓存型池子通常用于执行一些生存期很短的异步性任务
     *
     * 线程池为无限大，当执行当前任务时上一个任务已经完成，会复用执行上一个任务的线程，而不用每次建立线程
     */
    @Test
    public void test1() {
        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
        for(int i=0;i<10;i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            cachedThreadPool.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName() + "正在被执行");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }


    /**
     * Executors.newFixedThreadPool(int n)  创建一个可重用固定个数的线程池，以共享的无界队列方式来运行这些线程
     *
     * 定长线程池的大小最好根据系统资源进行设置。如Runtime.getRuntime().availableProcessors()
     */
    @Test
    public void test2() {
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(5);
        for(int i=0;i<100;i++) {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            fixedThreadPool.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName() + "正在被执行");
                }
            });
        }
    }


    /**
     * Executors.newScheduledThreadPool(int n) 创建一个定长线程池，支持定时及周期性任务执行
     */
    public static void test3() {
        ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(5);
        scheduledThreadPool.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                System.out.println("延迟1秒后每3秒执行一次");
            }
        },1,3, TimeUnit.SECONDS);
    }


    /**
     * Executors.newSingleThreadExecutor() 创建一个单线程化的线程池，它只会用唯一的工作线程来执行任务
     * 保证所有任务按照指定顺序执行
     */
    public static void test4() {
        ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();
        for(int i=0;i<10;i++) {
            final int index = i;
            singleThreadExecutor.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName() + " 正在被执行，打印的值是：" + index);
                    try {
                        Thread.sleep(500);

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }

    public static void main(String[] args) {
        test4();
    }

}

























