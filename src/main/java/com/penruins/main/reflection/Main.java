package com.penruins.main.reflection;

import org.junit.Test;

import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.*;
import java.util.ArrayList;
import java.util.Properties;
import java.util.Scanner;

/**
 * 反射
 *      反射机制是在「运行状态中」
 *      对于任意一个类，都能够知道之歌类的所有属性和方法
 *      对于任意一个对象，都能够调用它的任意一个方法和属性
 */
public class Main {

    /**
     * 通过反射获取类
     */
    @Test
    public void test() {
        /**
         * 获取反射对象（反射入口）： Class
         *      第一种方法 Class.forName() 全限定类名
         *      第二种方法 XX.class
         *      第三种方法 .getClass()
         */
        try {
            Class<?> perClass = Class.forName("com.penruins.main.reflection.Person");
            System.out.println(perClass);
        } catch(ClassNotFoundException e) {
            e.printStackTrace();
        }


        Class<?> perClass2 = Person.class;
        System.out.println(perClass2);



        Person per = new Person();
        Class<?> perClass3 = per.getClass();
        System.out.println(perClass3);
    }


    /**
     * 获取方法
     */
    @Test
    public void getMethod() {
        Class<?> perClass = null;
        try {
            perClass = Class.forName("com.penruins.main.reflection.Person");
        } catch(ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("获取所有的公共方法");
        Method[] methods =  perClass.getMethods();
        for(Method method : methods) {
            System.out.println(method);
        }
        System.out.println("获取所有的接口");
        Class<?>[] interfaces = perClass.getInterfaces();
        for(Class<?> inter : interfaces) {
            System.out.println(inter);
        }
        System.out.println("获取父类");
        Class<?> father = perClass.getSuperclass();
        System.out.println(father);
        // 注解生成的构造方法为什么没有？？？？
        System.out.println("获取构造方法");
        Constructor<?>[] constructors = perClass.getConstructors();
        for(Constructor<?> constructor : constructors) {
            System.out.println(constructor);
        }
        System.out.println("获取所有的公共属性");
        Field[] fields = perClass.getFields();
        for(Field field : fields) {
            System.out.println(field);
        }
        System.out.println("获取当前类的所有方法");
        System.out.println("只能是当前类，忽略访问修饰符限制");
        Method[] methods2 =  perClass.getDeclaredMethods();
        for(Method method : methods2) {
            System.out.println(method);
        }
        System.out.println("获取当前类的所有属性");
        Field[] fields2 = perClass.getDeclaredFields();
        for(Field field : fields2) {
            System.out.println(field);
        }
        System.out.println("获取当前反射获取对象（实例）");
        Person person = null;
        try {
            person = (Person) perClass.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        person.interfaceMethod();

    }

    /**
     * 动态加载类名和方法
     *
     * 这里实现的功能实际上是代码编译成字节码之后
     * 如果想要调用相应的类中的方法，可以直接修改txt文件
     *
     */
    @Test
    public void dynamicOperate() {
        Properties properties = new Properties();
        try {
            properties.load(new FileReader("./class.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        String classname = properties.getProperty("classname");
        String methodName = properties.getProperty("methodname");
        Class<?> perClass = null;
        try {
            perClass = Class.forName(classname);
        } catch(ClassNotFoundException e) {
            e.printStackTrace();
        }
        Person person = null;
        try {
            person = (Person) perClass.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        Method method = null;
        try {
            method = perClass.getMethod(methodName);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        try {
            method.invoke(person);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

    }

    /**
     * 反射可以越过泛型检查
     */
    @Test
    public void destroyGeneric() {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        Class<?> listClazz = list.getClass();
        Method method = null;
        try {
             method = listClazz.getMethod("add",Object.class);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        try {
            method.invoke(list,"zs....");
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        System.out.println(list);
    }


    @Test
    public void setProperty() {
        Person person = new Person();
        PropertyUtil.setProperty(person,"id",100);
        PropertyUtil.setProperty(person,"name","penruins");
        System.out.println(person);
    }

    /**
     * 通过反射操作一维数组
     */
    @Test
    public void operateArray() {
        String type = "java.lang.String";
        int num = 100;
        Class<?> c = null;
        try {
            c = Class.forName(type);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Object arr = Array.newInstance(c,num);

        //给数组的一个元素赋值
        Array.set(arr,0,"penruins");
        Array.set(arr,1,"penruinss");
        Array.set(arr,2,"penruinsss");
        System.out.println(Array.get(arr,0));
        System.out.println(Array.get(arr,1));
        System.out.println(Array.get(arr,2));
    }

    /**
     * 通过反射操作二维数组
     */
    @Test
    public void operateArray2() {
        Class c = Integer.TYPE;
        int[] dim = {3,3};
        Object arr = Array.newInstance(c,dim);
        //从二维数组中获取一行（第2行）
        Object arr2 = Array.get(arr,2);

        Array.set(arr2,1,369);

        System.out.println(Array.get(arr2,1));

    }
}


























