package com.penruins.main.basic.string.algorithm;

public class Main {
    /**
     * 判断一个字符串中，某个字符只有一个
     * @param data
     * @param c
     * @return
     */
    public static boolean onlyOnceString(String data,char c) {
        if(data.indexOf(c) == data.lastIndexOf(c)) {
            return true;
        } else {
            return false;
        }
    }


}
