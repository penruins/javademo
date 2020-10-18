package com.penruins.main.design_pattern.adapterPattern;

public class V5PowerAdapter implements V5Power{
    private V220Power v220Power;

    public V5PowerAdapter(V220Power v220Power) {
        this.v220Power = v220Power;
    }

    @Override
    public int provideV5Power() {
        int power = v220Power.provideV220Power();
        // 适配电压的各种过程
        System.out.println("适配器：我悄悄的适配了电压");
        return 5;
    }
}
