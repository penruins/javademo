package com.penruins.proxy.static_proxy;

import com.penruins.proxy.static_proxy.merchant.Taobao;
import com.penruins.proxy.static_proxy.merchant.WechatMerchat;

public class ShopMain {
    public static void main(String[] args) {
        //创建代理的商家taobao对象
        Taobao taobao = new Taobao();
        float price = taobao.sell(1);
        System.out.println("通过淘宝的商家，购买u盘单价："
                + price);

        System.out.println("------------------");
        WechatMerchat wechatMerchat = new WechatMerchat();
        float price2 = wechatMerchat.sell(1);
        System.out.println("通过微商的商家，购买u盘单价："
                + price2);
    }
}
