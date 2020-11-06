package com.penruins.file;

import org.junit.Test;

import java.io.*;
import java.util.*;

public class SplitFile {

  /**
   * 拆分文件测试
   * @throws IOException
   */
  @Test
  public void splitTest() throws IOException {
    File resFile = new File("src/main/resources/wallhaven-oxkjgm.jpg"); //原文件（待拆分的文件）
    File splitDir = new File("src/main/resources/splitDir");//拆分后的目录
    splitFile(resFile,splitDir);
  }

  /**
   * 合并文件测试
   * @throws IOException
   */
  @Test
  public void mergeTest() throws IOException {
    //读取多个拆分后的文件 inputStreamList 所有输入流的集合
    List<FileInputStream> inputStreamList = new ArrayList<>();
    for(int i=1;i<=5;i++) {
      inputStreamList.add(new FileInputStream("src/main/resources/splitDir/" + i + ".part"));
    }
    OutputStream out = new FileOutputStream("src/main/resources/splitDir/wallpaper.jpg"); //指定合并后的文件输出流
    //将多个输入流依次读入内存，最后再一次性输出
    byte[] buf = new byte[1024*1024];
    for(FileInputStream in : inputStreamList) {
      int len = in.read(buf);
      out.write(buf,0,len);
    }
    out.close();

  }

  /**
   * 合并文件测试2
   */
  @Test
  public void mergeTest2() throws IOException {
    File splitDir = new File("src/main/resources/splitDir");
    mergeFile(splitDir);
  }

  /**
   * 合并文件测试3
   * @throws IOException
   */
  @Test
  public void mergeTest3() throws IOException {
    File confFile = new File("src/main/resources/splitDir/6.conf");
    readConfig(confFile);
  }

  private static void readConfig(File confFile) throws IOException {
    BufferedReader bReader = new BufferedReader(new InputStreamReader(new FileInputStream(confFile)));
    String line = null;
    while((line=bReader.readLine())!= null) {
      if(line.charAt(0) == '#') continue;
      String[] arr = line.split("=");
      if(line.startsWith("filename")) {
        System.out.println("filename:" + arr[1]);
      } else if(line.startsWith("partcount")) {
        System.out.println("partcount:" + arr[1]);
      }
    }
    bReader.close();

  }
  private static Properties getProperties() throws IOException {
    String configFileName = "src/main/resources/splitDir/6.conf";
    Properties properties = new Properties();
    properties.load(new FileInputStream(configFileName));
    return properties;
  }


  private static void mergeFile(File splitDir) throws IOException {

    Properties properties = getProperties();
    String filename = properties.getProperty("filename");
    int partcount = Integer.valueOf(properties.getProperty("partcount"));

    OutputStream out = new FileOutputStream("src/main/resources/splitDir/" + filename);
    List<FileInputStream> inputStreamList = new ArrayList<>();
    for(int i=1;i<=partcount;i++) {
      inputStreamList.add(new FileInputStream("src/main/resources/splitDir/" + i + ".part"));
    }

    /**
     * SequenceInputStream 表示其他输入流的逻辑串联。它从输入流的有序集合开始，并从第一个输入流开始读取，直到到达文件末尾，接着从第二个输入流读取，以此类推，直到到达包含的最后一个输入流的
     * 文件末尾为止
     * SequenceInputStream represents the logical concatenation of other input streams. It starts out with an ordered collection of input stream and reads from
     * the first one until end of file is reached, whereupon it reads from the second one, and so on, until end of file is reached on the last of the contained
     * input streams.
     */
    Enumeration<FileInputStream> en = Collections.enumeration(inputStreamList);
    SequenceInputStream sin = new SequenceInputStream(en);//多个流->1个流
    byte[] buf = new byte[1024];
    int len = -1;
    while((len=sin.read(buf))!=-1) {
      out.write(buf,0,len);
    }
    out.flush();
    out.close();
    sin.close();
  }

  /**
   * 拆分
   *
   * 拆分的时候：如何将文件名、拆分的数量保留，为后续合并做准备 （通过配置文件）
   * @param resFile
   * @param splitDir
   */
  private static void splitFile(File resFile, File splitDir) throws IOException {
    if(!splitDir.exists()) {
      splitDir.mkdir();
    }


    InputStream in = new FileInputStream(resFile);
    OutputStream out = null;
    byte[] buf = new byte[1024*1024]; //定义缓冲区为1M，当缓冲区满时，一次性刷出成一个文件
    int len = -1;
    int count = 1;
    while((len=in.read(buf)) != -1) {
      out = new FileOutputStream(new File(splitDir,count++ +".part"));
      out.write(buf,0,len);
      out.flush();//清理缓冲区
      out.close(); //关闭流、关闭之前会强行清理缓冲区
    }


    /* 第一种方式
    out = new FileOutputStream(new File(splitDir,count +".conf"));
    String lineSeparator = System.getProperty("line.separator");//查询当前操作系统的换行符
    out.write(("filename=" +resFile.getName() + lineSeparator).getBytes());
    out.write(("partcount="+(count-1)).getBytes());
    out.flush();

     */

    /**
     * 第二种方式 Properties 将内存中的多个属性以key=value的形式写到硬盘中
     */
    out = new FileOutputStream(new File(splitDir,count +".conf"));
    Properties properties = new Properties();
    properties.setProperty("filename",resFile.getName());
    properties.setProperty("partcount",(count-1)+"");
    properties.store(out,"file configuration...");//写入硬盘 持久化


    in.close();




  }



}
