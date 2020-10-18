package com.penruins.main.design_pattern.factoryPattern;

/**
 * 把工厂实例作为参数注入到操作中，而不是在每个方法内部自行创建
 */
public class ProductConsumer {
    SimpleFactoryFixture.Factory factory;
    public ProductConsumer(SimpleFactoryFixture.Factory factory) {
        this.factory = factory;
    }

    public void handleWithProductMethod1() {
        Product product = factory.newInstance();
        // 其他需要依赖于product的操作
    }
    public void handleWithProductMethod2() {
        Product product = factory.newInstance();
        // 其他需要依赖于product的操作
    }
}
