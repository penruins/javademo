package com.penruins.main.design_pattern.strategyPattern;

public abstract class Role {
    protected String name;
    protected abstract void display();
    protected abstract void run();
    protected abstract void attack();
    protected abstract void defend();
}
