package com.penruins.main.reflection;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person implements MyInterface,MyInterface2{
    private int id;
    private String name;
    private int age;
    public String publicName;


    @Override
    public void interfaceMethod() {
        System.out.println("interfaceMethod....");
    }

    public Person(int id) {
        this.id = id;
    }

    public static void staticMethod() {
        System.out.println("staticMethod...");
    }

    private void privateMethod() {
        System.out.println("private method...");
    }

    @Override
    public void interfaceMethod2() {
        System.out.println("interfaceMethod2....");
    }
}
