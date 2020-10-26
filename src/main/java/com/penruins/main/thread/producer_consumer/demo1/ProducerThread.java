package com.penruins.main.thread.producer_consumer.demo1;

public class ProducerThread implements Runnable{
    private Engine engine;
    private int number = 0;

    public ProducerThread(Engine engine) {
        this.engine = engine;
    }

    @Override
    public void run() {
        //模拟向引擎中加入100条订单
        for(int i= 0;i<100;i++) {
            engine.addOrder(produceOrder());

            try {
                Thread.sleep(100*(number %10));
            } catch(InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private Order produceOrder() {
        Order order = new Order();
        order.setCommodityId("id_" + number);
        order.setCommodityName("name_"+number);
        order.setPrice(new Double(number));
        order.setQuantity(number);

        number++;

        return order;
    }
}
