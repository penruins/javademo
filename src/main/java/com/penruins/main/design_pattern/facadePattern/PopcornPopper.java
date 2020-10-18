package com.penruins.main.design_pattern.facadePattern;

public class PopcornPopper {
    public void on() {
        System.out.println("打开爆米花机");
    }

    public void makePopcorn() {
        System.out.println("制作爆米花");
    }

    public void off() {
        System.out.println("关闭爆米花机");
    }

    public void stopMakePopcorn() {
        System.out.println("停止制作爆米花");
    }
}
