package com.penruins.main.thread.producer_consumer.demo1;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

public class Engine {
    private BlockingQueue<Order> orderQueue = new LinkedBlockingDeque<Order>();


    /**
     * 获取订单
     * 如果订单队列为空将一直等待，直到有新的订单或者被中断
     * @return
     */
    public Order getOrder() {
        Order order = null;
        try {
            order = orderQueue.take();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return order;
    }


    /**
     * 添加订单
     * 如果订单队列已满将一直等待，直到队列有可用空间或者被中断
     * @param order
     */
    public void addOrder(Order order) {
        try {
            orderQueue.put(order);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
