package com.penruins.proxy.static_proxy;

/**
 * 表示功能的
 * 厂家、商家都要完成的功能
 */
public interface USBSell {

    /**
     *
     * @param amount 表示一次购买的数量
     * @return 一个U盘的价格
     */
    float sell(int amount);
}
