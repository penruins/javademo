package com.penruins.main.thread.producer_consumer.demo1;

public class ConsumerThread implements Runnable{
    private Engine engine;

    public ConsumerThread(Engine engine) {
        this.engine = engine;
    }

    @Override
    public void run() {
        while(true) {
            Order order = engine.getOrder();
            disposeOrder(order);
        }
    }

    private void disposeOrder(Order order) {
        System.out.println("i处理订单信息[ " + order.toString() + " ] ");

    }
}
