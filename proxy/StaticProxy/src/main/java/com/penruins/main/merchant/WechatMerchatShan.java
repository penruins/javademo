package com.penruins.main.merchant;

import com.penruins.main.USBSell;
import com.penruins.main.factory.USBShanFactory;

public class WechatMerchatShan implements USBSell {

  private USBShanFactory factory = new USBShanFactory();

  @Override
  public float sell(int amount) {
    float price = factory.sell(amount);
    price += 1;
    return price;
  }
}
