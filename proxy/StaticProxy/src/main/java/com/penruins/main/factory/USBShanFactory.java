package com.penruins.main.factory;

import com.penruins.main.USBSell;

/**
 * 目标类：闪迪厂家
 *
 *
 */
public class USBShanFactory implements USBSell {
    @Override
    public float sell(int amount) {
        System.out.println("目标类中的方法调用，" +
                "USBShanFactory中的sell");

        return 100;
    }
}
