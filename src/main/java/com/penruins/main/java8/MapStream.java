package com.penruins.main.java8;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class MapStream {
    static Map<Integer,String> map = new HashMap<>();
    static {
        for(int i=0;i<10;i++)
            map.putIfAbsent(i,"val"+i);
    }

    @Test
    public void demo1() {
        map.forEach((id,val) -> System.out.println(val));
    }
}
