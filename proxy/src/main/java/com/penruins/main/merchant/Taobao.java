package com.penruins.main.merchant;

import com.penruins.main.USBSell;
import com.penruins.main.factory.USBKingFactory;
/**
 * 静态代理的特点：实现简单 容易理解
 * 缺点 当目标类增加了，代理类可能也需要成倍的增加。代理类数量过多
 *     当你的接口中功能增加了，或者修改了，会影响众多的实现类，厂家类，代理都需要修改，影响比较多
 */


/**
 * 淘宝是一个商家，代理金士顿U盘的销售
 *
 *
 * 代理类完成的功能
 *    目标类中方法的调用
 *    功能增强
 */
public class Taobao implements USBSell {

  private USBKingFactory factory = new USBKingFactory(); //声明 商家代理的厂家是谁

  /**
   * 实现销售U盘的功能
   * @param amount 表示一次购买的数量
   * @return
   */
  @Override
  public float sell(int amount) {
    float price = factory.sell(amount);//向厂家发送订单，告诉厂家，我买了U盘，厂家发货
    /**
     * 商家 需要加价，也就是代理要增加价格
     *
     * 增强功能，代理类在完成目标类方法调用后
     * 增强了功能
     */
    price = price + 25;

    System.out.println("淘宝商家，给你返了一个优惠券，或者红包");

    return price;//增加的价格
  }
}
