package com.penruins.main.merchant;

import com.penruins.main.USBSell;
import com.penruins.main.factory.USBKingFactory;

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
