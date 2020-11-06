package com.penruins.main.merchant;

import com.penruins.main.USBSell;
import com.penruins.main.factory.USBShanFactory;


public class TaobaoShan implements USBSell {

  private USBShanFactory factory = new USBShanFactory();

  @Override 
  public float sell(int amount) {
    float price = factory.sell(amount);
    price = price + 25;
    return price;
  }
}
