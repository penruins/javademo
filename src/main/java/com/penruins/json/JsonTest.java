package com.penruins.json;

import com.mysql.cj.xdevapi.JsonArray;
import org.apache.commons.io.FileUtils;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Test;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class JsonTest {
  /**
   * 将map转换为json
   */
  @Test
  public void test() {
    Map<String,String> map = new HashMap<>();
    map.put("s01","zs");
    map.put("s02","ls");
    map.put("s03","ww");
    //map->json
    JSONObject jsonObject = new JSONObject(map);
    System.out.println(jsonObject);
  }


  /**
   * JavaBean -> json
   */
  @Test
  public void test2() {
    Person person = new Person();
    person.setName("penruins");
    person.setAge(22);
    Address address = new Address("西安","昆明");
    person.setAddress(address);
    JSONObject jsonObject = new JSONObject(person);
    System.out.println(jsonObject);
  }


  /**
   * file -> json
   */
  @Test
  public void test3() throws IOException {
    InputStreamReader in = new InputStreamReader(new FileInputStream("src/main/resources/jsonTest.json"));
    char[] buf = new char[10];
    int len = -1;
    StringBuffer sb = new StringBuffer();
    while((len = in.read(buf))!=-1) {
      String str = new String(buf,0,len);
      sb.append(str);
    }
    String s = sb.toString();
    JSONObject json = new JSONObject(s);
    System.out.println(json);
  }


  /**
   * file -> json 简单方法
   *  使用commons-io
   */
  @Test
  public void test4() throws IOException {
    String s = FileUtils.readFileToString(new File("src/main/resources/jsonTest.json"),"utf-8");
    JSONObject json = new JSONObject(s);
    System.out.println(json);
  }

  /**
   * 生成json文件
   */
  @Test
  public void test5() throws IOException {
    Map<String,Person> map = new HashMap<>();
    Person person = new Person();
    person.setName("penruins");
    person.setAge(22);
    Address address = new Address("西安","昆明");
    person.setAddress(address);
    map.put("p1",person);
    map.put("p2",person);
    map.put("p3",person);
    JSONObject jsonObject = new JSONObject(map);
    Writer writer = new FileWriter("src/main/resources/jsonOutput.json");
    jsonObject.write(writer);
    writer.flush();

  }

  /**
   * JsonArray
   */
  @Test
  public void test6() {
    String jsonArrayStr = "[{\"address\":{\"schoolAddress\":\"昆明\",\"homeAddress\":\"西安\"},\"name\":\"penruins\",\"age\":22}," +
            "{\"address\":{\"schoolAddress\":\"昆明\",\"homeAddress\":\"西安\"},\"name\":\"penruins\",\"age\":22}," +
            "{\"address\":{\"schoolAddress\":\"昆明\",\"homeAddress\":\"西安\"},\"name\":\"penruins\",\"age\":22}]";
    JSONArray jsonArray = new JSONArray(jsonArrayStr);
    System.out.println(jsonArray);
  }

  /**
   * map转换为jsonArray
   *    对于json的类型转换，通常需要引入另一个json库
   */
  @Test
  public void test7() {
    Map<String,String> map = new HashMap<>();
    map.put("key1","value1");
    map.put("key2","value2");
    map.put("key3","value3");
    net.sf.json.JSONArray jsonArray = new net.sf.json.JSONArray();
    jsonArray = jsonArray.fromObject(map);
    System.out.println(jsonArray);
  }




}















