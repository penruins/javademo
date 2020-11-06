package com.penruins.proxy.static_proxy.merchant;


import com.penruins.proxy.static_proxy.USBSell;
import com.penruins.proxy.static_proxy.factory.USBShanFactory;

public class TaobaoShan implements USBSell {

  private USBShanFactory factory = new USBShanFactory();

  @Override 
  public float sell(int amount) {
    float price = factory.sell(amount);
    price = price + 25;
    return price;
  }
}
