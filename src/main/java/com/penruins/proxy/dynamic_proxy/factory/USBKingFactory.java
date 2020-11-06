package com.penruins.proxy.dynamic_proxy.factory;


import com.penruins.proxy.dynamic_proxy.USBSell;

/**
 * 目标类：金士顿厂家
 *
 * 不接受用户的单独购买
 */
public class USBKingFactory implements USBSell {
    @Override
    public float sell(int amount) {
        System.out.println("目标类中，执行sell目标方法");
        return 85;
    }
}
