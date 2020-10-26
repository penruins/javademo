package com.penruins.main.thread.blocking_queue;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * offer(anObject) 表示如果可能的话，将anObject加到BlockingQueue里
 * 如果BlockingQueue可以容纳，则返回true，否则返回false
 * 本方法不阻塞当前执行方法
 *
 * offer(E o,long timeout,TimeUnit unit) 可以设定等待的时间
 * 如果在指定的时间内，还不能往队列中加入BlockingQueue,则返回失败
 *
 * put(anObject) 把anObject加到BlockingQueue里，如果BlockingQueue
 * 没有空间，则调用次方法的线程被阻断知道BlockingQueue里面有空间再继续
 *
 * poll(time) 取走BlockingQueue里排在首位的对象，若不能立即取出
 * 则可以等time参数规定的时间，取不到时返回null
 *
 * poll（long timeout,TimeUnit unit)
 *
 * take() 取走首位的对象，如果为空，阻断键入等待状态知道有新的数据加入
 *
 * drainTo() 一次性取出所有可用的数据对象（还可以指定获取数据的个数）
 * 通过该方法，可以获取数据效率；不需要多次分批加锁或释放锁
 *
 *
 *
 *
 *
 *
 * 常见的BlockingQueue
 * ArrayBlockingQueue
 *      基于数组的阻塞队列实现，在其内部，维护了一个定长数组，以便缓存队列中的
 *      数据对象，这是一个常用的阻塞队列，除了一个定长数组外，内部还保存着两个
 *      整型变量，分别标识着队列的头部和尾部在数组中的位置
 *
 * LinkedBlockingQueue
 *      如果构造一个linkedBlockingQueue对象，而没有指定其容量大小，它会默认
 *      一个类似无限大小的容量（Integer.MAX_VALUE)，这样的话，如果生产者的
 *      速度一旦大于消费者的速度，也许还没有等待队列满阻塞产生，系统内存就有可能
 *      被消耗殆尽了。
 */
public class Main {
    public static void main(String[] args) {
        BlockingDeque<String> queue = new LinkedBlockingDeque<>(10);

        Producer producer1 = new Producer(queue);
        Producer producer2 = new Producer(queue);
        Producer producer3 = new Producer(queue);
        Consumer consumer = new Consumer(queue);

        ExecutorService service = Executors.newCachedThreadPool();
        service.execute(producer1);
        service.execute(producer2);
        service.execute(producer3);
        service.execute(consumer);


    }

}
















