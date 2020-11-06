package com.penruins.basic.serialize;

import lombok.SneakyThrows;
import org.junit.Test;

import java.io.*;

public class SerializeTest {


    /**
     * 序列化
     * 实现Serializable接口的目的是为类可持久化，比如在网络传输或本地存储，为系统的分布和异构部署提供先决条件
     * 若没有序列化，现在我们所熟悉的远程调用，对象数据库都不可能存在
     *
     * serialVersionUID适用于java序列化机制。简单来说，JAVA序列化的机制是通过判断类的serialVersionUID来验证的。
     * 在进行反序列化时，JVM会把传来的字节流中的serialVersionUID与本地相应实体类的serialVersionUID进行比较。
     * 如果相同说明是一致的，可以进行反序列化，否则会出现反序列化版本一致的异常，即是InvalidCastException
     *
     *
     * serialVersionUID有两种显式的生成方式
     * 1. 默认的1L，比如 private static final long serialVersionUID = 1L;
     * 2. 根据包名，类名，继承关系，非私有的方法和属性，以及参数，返回值等诸多因子计算得出的，极度复杂生成的一个64位的哈希字段。
     *      基本上算出来的这个值是唯一的。
     *
     *
     *  当实现java.io.Serializable接口中没有显示的定义serialVersionUID变量的时候，JAVA序列化机制会根据Class自动生成一个
     *  serialVersionUID作序列化版本比较用，这种情况下，如果class文件没有发明变化，就算再编译多次，serialVersionUID也不会变化
     *
     *
     */
    @Test
    @SneakyThrows
    public void demo1() {
        Employee e = new Employee();
        e.name = "Reyan Ali";
        e.address = "Phokka Kuan, Ambehta Peer";
        e.SSN = 11122333;
        e.number = 101;

        FileOutputStream fileOut = new FileOutputStream("employee.ser");
        ObjectOutputStream out = new ObjectOutputStream(fileOut);
        out.writeObject(e);
        out.close();
        fileOut.close();
        System.out.println("Serialized data is saved in employee.ser");
    }

    /**
     * 反序列化
     */
    @SneakyThrows
    @Test
    public void demo2() {
        Employee e = null;
        FileInputStream fileInputStream = new FileInputStream("employee.ser");
        ObjectInputStream in = new ObjectInputStream(fileInputStream);
        e = (Employee) in.readObject();
        in.close();
        fileInputStream.close();
        System.out.println(e);
    }

}
