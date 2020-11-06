package com.penruins.socket;

import java.util.LinkedList;

public class ThreadPool extends ThreadGroup{
    private boolean isClosed = false;
    private LinkedList<Runnable> workQueue;
    private static int threadPoolID;
    private int threadID;

    public ThreadPool(int poolSize) {
        super("ThreadPool-" + (threadPoolID++));
        setDaemon(true);
        workQueue = new LinkedList<>();
        for(int i=0;i<poolSize;i++) {
            new WorkThread().start();
        }
    }

    /**
     * 向工作队列中加入一个新任务，由工作线程去执行该任务
     * @param task
     */
    public synchronized void execute(Runnable task) {
        if(isClosed) {
            throw new IllegalStateException();
        }
        if(task != null) {
            workQueue.add(task);
            notify(); //唤醒正在getTask()方法中等待任务的工作线程
        }
    }

    protected synchronized Runnable getTask() throws InterruptedException {
        while(workQueue.size() == 0) {
            if(isClosed) return null;
            wait();
        }
        return workQueue.removeFirst();
    }

    /**
     * 关闭线程池
     */
    public synchronized void close() {
        if(!isClosed) {
            isClosed = true;
            workQueue.clear();
            interrupt();
        }
    }

    /**
     * 等待工作线程把所有任务执行完
     */
    public void join() {
        synchronized (this) {
            isClosed = true;
            notifyAll();
        }

        Thread[] threads = new Thread[activeCount()];
        int count = enumerate(threads);
        for(int i=0;i<count;i++) {
            try {
                threads[i].join();
            } catch (InterruptedException ex) {

            }
        }
    }

    /**
     * 内部类：工作线程
     */
    private class WorkThread extends Thread {
        public WorkThread() {
            super(ThreadPool.this,"WorkThread-" + (threadID++));
        }

        public void run() {
            while(!isInterrupted()) { //isInterrupted()方法继承自Thread类，判断线程是否被中断
                Runnable task = null;
                try {
                    task = getTask();
                } catch (InterruptedException ex) {

                }

                if(task == null) return;
                try {
                    task.run();
                } catch(Throwable t) {
                    t.printStackTrace();
                }
            }
        }
    }
}
