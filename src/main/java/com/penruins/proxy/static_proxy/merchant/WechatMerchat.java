package com.penruins.proxy.static_proxy.merchant;


import com.penruins.proxy.static_proxy.USBSell;
import com.penruins.proxy.static_proxy.factory.USBKingFactory;

public class WechatMerchat implements USBSell {

  /**
   * 代理的是 金士顿 定义目标厂家类
   */
  private USBKingFactory factory = new USBKingFactory();

  @Override
  public float sell(int amount) {
    float price = factory.sell(amount);
    price += 1;
    return price;
  }
}
