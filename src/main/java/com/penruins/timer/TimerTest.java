package com.penruins.timer;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Timer是一种定时器工具，用来在后台线程计划执行指定任务。它可以计划执行一个一次或反复多次
 * TimerTask是一个抽象类，它的子类代表一个可以被Timer计划的任务。具体的任务在TimerTask中run接口中实现
 * 通过Timer中的schedule方法启动定时任务
 *
 * 启动一个定时器实质是启动一个线程
 */
public class TimerTest {
  /**
   * 在指定日期运行定时器任务，只运行一次
   *
   * 在指定的日期运行一次定时任务
   * 如果date日期在今天之前，则启动定时器后，立即运行一次定时任务run方法
   * 如果date日期在今天之后，则启动定时器后，会在指定的将来日期运行一次任务run方法
   *
   */
  public static void test() throws ParseException {
    String sdata = "2020-10-28";
    SimpleDateFormat format = new SimpleDateFormat("yy-MM-dd");
    Date date = format.parse(sdata);
    Timer timer = new Timer();
    timer.schedule(new TimerTask() {
      @Override
      public void run() {
        System.out.println("系统正在运行...");
      }
    },date);

  }


  /**
   * 在距当前时刻的一段时间后运行定时器任务，只运行一次
   */
  public static void test2() {
    Timer timer = new Timer();
    timer.schedule(new TimerTask() {
      @Override
      public void run() {
        System.out.println("系统正在运行");
      }
    },5000);
  }

  /**
   * 在指定的时间后，每隔指定的时间，重复运行定时器任务
   */
  public static void test3() throws ParseException {
    String sdata = "2020-10-27";
    SimpleDateFormat format = new SimpleDateFormat("yy-MM-dd");
    Date date = format.parse(sdata);
    Timer timer = new Timer();
    timer.schedule(new TimerTask() {
      @Override
      public void run() {
        System.out.println("系统正在运行");
      }
    },date,2000);
  }

  /**
   * 在距当前时刻的一段指定距离后，每隔指定时间运行一次定时器任务
   */
  public static void test4() {
    Timer timer = new Timer();
    timer.schedule(new TimerTask() {
      @Override
      public void run() {
        System.out.println("系统正在运行");
      }
    },5000,2000);
  }

  /**
   *  停止计时器
   *    实质是终止Timer的线程。默认情况下，创建的Timer线程会一直执行，如果要停止的话主要有一下四种方法终止Timer线程
   *      1. 调用Timer的cancel方法
   *      2. 把Timer线程设置成Daemon守护线程，当所有的用户线程结束后，那么守护线程也会被终止
   *      3. 当所有的任务执行结束后，删除对应Timer对象的引用，线程也会被终止
   *      4. 调用System.exit方法终止程序
   *
   *
   *  举例用cancel方法终止Timer线程
   */
  public static void test5() throws InterruptedException {
    Timer timer = new Timer();
    timer.schedule(new TimerTask() {
      @Override
      public void run() {
        System.out.println("系统正在运行");
      }
    },1000,500);
    Thread.sleep(10000);
    timer.cancel();
  }


  public static void main(String[] args) throws ParseException, InterruptedException {
    test5();
  }
}
