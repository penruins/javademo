package com.penruins.computer;

public class Test {

    @org.junit.Test
    public void test() {
        INT INT = new INT();
        byte[] tmp = INT.decimal_to_binary(64+128);
        for(byte b : tmp) {
            System.out.print(" " + b);
        }
    }
}
