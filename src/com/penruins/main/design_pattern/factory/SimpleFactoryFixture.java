package com.penruins.main.design_pattern.factory;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class SimpleFactoryFixture {
    class Factory {
        public Product newInstance() {
            return new ProductA();
        }
    }

    @Test
    public void testSimpleFactory() {
        assertTrue(new Factory().newInstance() instanceof ProductA);
        //采用工厂类型与直接使用new()有什么不同？
        //通过Product接口隔离了客户程序与具体类型(ProductX)的依赖关系，在客户程序视野内根本就不存在ProductX，只有Product接口就可以
        //客户无需关心ProductX的变化。Factory将ProductX的变化与客户程序隔开了
    }
}
