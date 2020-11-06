package com.penruins.java8;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortString {

    /**
     * 老版本要这样写
     */
    @Test
    public void demo1() {
        List<String> names = Arrays.asList("peter","anna","mike","xenia");
        names.forEach(name -> System.out.println(name));
        System.out.println("-----------------");
        Collections.sort(names, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.compareTo(o1);
            }
        });
        names.forEach(name -> System.out.println(name));
    }

    /**
     * 现在这样写
     */
    @Test
    public void demo2() {
        List<String> names = Arrays.asList("peter","anna","mike","xenia");
        Collections.sort(names, (String a,String b) -> b.compareTo(a));
        names.forEach(name -> System.out.println(name));
    }
}
