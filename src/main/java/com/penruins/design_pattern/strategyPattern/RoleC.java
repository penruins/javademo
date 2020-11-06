package com.penruins.design_pattern.strategyPattern;

public class RoleC extends Role{
    public RoleC(String name) {
        this.name = name;
    }

    @Override
    protected void display() {
        System.out.println("样子1");
    }

    @Override
    protected void run() {
        System.out.println("烟雾弹");
    }

    @Override
    protected void attack() {
        System.out.println("九阳神功");
    }

    @Override
    protected void defend() {
        System.out.println("铁布衫");
    }
}
