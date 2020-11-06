package com.penruins.thread.producer_consumer.demo1;

public class Test {
    public static void main(String[] args) {
        Engine engine = new Engine();
        ProducerThread pt = new ProducerThread(engine);
        ConsumerThread ct = new ConsumerThread(engine);

        Thread pth = new Thread(pt);
        pth.setName("生产者线程");
        Thread cth = new Thread(ct);
        cth.setName("消费者线程");
        pth.start();
        cth.start();
    }
}
