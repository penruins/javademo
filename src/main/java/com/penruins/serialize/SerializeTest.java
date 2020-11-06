package com.penruins.serialize;

import org.junit.Test;

import java.io.*;

public class SerializeTest {

  /**
   * 序列化测试
   * @throws IOException
   */
  @Test
  public void test() throws IOException {
    Person person = new Person("penruins",22);
    ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("src/main/resources/per.obj"));
    oos.writeObject(person);//将对象写入内存
    oos.close();
  }

  /**
   * 反序列化测试
   * @throws IOException
   * @throws ClassNotFoundException
   */
  @Test
  public void test2() throws IOException, ClassNotFoundException {
    ObjectInputStream ois = new ObjectInputStream(new FileInputStream("src/main/resources/per.obj"));
    Person person = (Person) ois.readObject();
    System.out.println(person);
  }
}
