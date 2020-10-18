package com.penruins.main.basic.serialize;

import lombok.SneakyThrows;
import org.junit.Test;

import java.io.*;

public class SerializeTest {


    /**
     * 序列化
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
