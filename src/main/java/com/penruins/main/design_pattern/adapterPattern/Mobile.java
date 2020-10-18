package com.penruins.main.design_pattern.adapterPattern;

public class Mobile {
    public void inputPower(V5Power power) {
        int provideV5Power = power.provideV5Power();
        System.out.println("手机：我需要5V电压充电，现在是-->" + power.provideV5Power());
    }
}
