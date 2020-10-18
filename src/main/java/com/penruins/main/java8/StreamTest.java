package com.penruins.main.java8;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class StreamTest {
    static List<String> stringList = new ArrayList<>();
    static {
        stringList.add("ddd2");
        stringList.add("aaa2");
        stringList.add("bbb1");
        stringList.add("aaa1");
        stringList.add("bbb3");
        stringList.add("ccc");
        stringList.add("bbb2");
        stringList.add("ddd1");
    }

    @Test
    public void demo1() {
        stringList.stream().filter(s -> s.startsWith("a")).forEach(System.out::println);
        System.out.println();
        stringList.stream().sorted().filter(s -> s.startsWith("a")).forEach(System.out::println);
        System.out.println();
        System.out.println(stringList);
    }

    @Test
    public void demo2() {
        stringList.stream().map(String::toUpperCase).sorted((a,b)->b.compareTo(a)).forEach(System.out::println);
    }

    @Test
    public void demo3() {
        boolean anyStartsWithA = stringList.stream().anyMatch(s -> s.startsWith("a"));
        System.out.println(anyStartsWithA);
        boolean allStartsWithA = stringList.stream().allMatch(s -> s.startsWith("a"));
        System.out.println(allStartsWithA);
        boolean noneStartsWithZ = stringList.stream().noneMatch(s -> s.startsWith("z"));
        System.out.println(noneStartsWithZ);
    }


    @Test
    public void demo4() {
        long startsWithB = stringList.stream().filter(s -> s.startsWith("b")).count();
        System.out.println(startsWithB);
    }

    @Test
    public void demo5() {
        Optional<String> reduced = stringList.stream().sorted().reduce((s1,s2) -> s1 + "#" + s2);
        reduced.ifPresent(System.out::println);
    }

    @Test
    public void demo6() {
        String concat = Stream.of("A","B","C","D").reduce("",String::concat);
        System.out.println(concat);
        double minValue = Stream.of(-1.5,1.0,-3.0,-2.0).reduce(Double.MAX_VALUE,Double::min);
        System.out.println(minValue);
        int sumValue = Stream.of(1,2,3,4).reduce(0,Integer::sum);
        System.out.println(sumValue);
        concat = Stream.of("a","B","c","D","e","F").filter(x -> x.compareTo("Z") > 0 ).reduce("",String::concat);
        System.out.println(concat);
    }
}
