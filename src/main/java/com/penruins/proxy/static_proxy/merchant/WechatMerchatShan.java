package com.penruins.proxy.static_proxy.merchant;


import com.penruins.proxy.static_proxy.USBSell;
import com.penruins.proxy.static_proxy.factory.USBShanFactory;

public class WechatMerchatShan implements USBSell {

  private USBShanFactory factory = new USBShanFactory();

  @Override
  public float sell(int amount) {
    float price = factory.sell(amount);
    price += 1;
    return price;
  }
}
