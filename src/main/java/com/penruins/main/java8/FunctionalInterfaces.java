package com.penruins.main.java8;

import org.junit.Test;

public class FunctionalInterfaces {
    @Test
    public void demo1() {
        Converter<String,Integer> converter = (from) -> Integer.valueOf(from);
        Integer converted = converter.convert("123");
        System.out.println(converted.getClass());
    }

    @Test
    public void demo2() {
        class Something {
            String startsWith(String s) {
                return String.valueOf(s.charAt(0));
            }
        }
        Something something = new Something();
        Converter<String,String> converter = something::startsWith;
        String converted = converter.convert("Java");
        System.out.println(converted);
    }

    @Test
    public void demo3() {
        PersonFactory<Person> personFactory = Person::new;
        Person person = personFactory.create("Peter","Parker");
    }


    public void demo4() {
        final int num = 1;
        Converter<Integer,String> stringConverter = (from) -> String.valueOf(from+num);
        System.out.println(stringConverter.convert(2));;
    }

    public void demo5() {
        int num = 1;
        Converter<Integer,String> stringConverter = (from) -> String.valueOf(from+num);
        System.out.println(stringConverter.convert(2));
    }
//    public void demo7() {
//        int num = 1;
//        Converter<Integer,String> stringConverter = (from) -> String.valueOf(from+num);
//        System.out.println(stringConverter.convert(2));
//        num = 2;
//    }

    @Test
    public void demo6() {
        System.out.println("--- run demo4() ---");
        demo4();
        System.out.println("--- run demo5() ---");
        demo5();
//        System.out.println("--- run demo7() ---");
//        demo7();
    }
}
