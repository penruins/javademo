package com.penruins.proxy.static_proxy.factory;


import com.penruins.proxy.static_proxy.USBSell;

/**
 * 目标类：金士顿厂家
 *
 * 不接受用户的单独购买
 */
public class USBKingFactory implements USBSell {
    @Override
    public float sell(int amount) {
        System.out.println("目标类中的方法调用，" +
                "USBKingFactory中的sell");
        /**
         * 一个128G的U盘 85元
         * 后期可以根据amount，可以实现不同的价格
         * 例如一次买10000个，单价是80
         * 一次买50000个，单价是75
         */
        return 85;
    }
}
