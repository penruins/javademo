package com.penruins.bitset;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.BitSet;

/**
 *  BitSet类实现了一个按需增长的位向量。位set的每个组件都有一个车boolean值。用非负的整数将BitSet的位编入
 *  索引。可以对每个编入索引的位进行测试、设置或者清除。通过逻辑与、逻辑或和逻辑异或操作
 *  可以使用一个BitSet修改另一个BitSet的内容
 *
 *  默认情况下，set中所有位的初始值都是false
 *
 *  每个位set都有一个当前大小，也就是该位setset当前所用空间的位数。主义，这个大小与位set的实现有关，所以它可能随
 *  实现的不同而更改。位set的长度与位set的逻辑长度有关，并且是与现实无关而定义的
 *
 *  除非另行说明，否则将null参数传递给BitSet中的任何方法都将导致NullPointerException
 *
 *  在没有外部同步的情况下，多个线程操作一个车BitSet是不安全的
 *
 *
 * 顾名思义，就是位集合 BitSet 是从JDK 1.0 就出现的东西，后面的版本又慢慢强化
 *
 *  大端模式，是指数据的高字节保存在内存的低地址中，而数据的低字节保存在内存的高地址中
 *  小端模式，是指数据的高字节保存在内存的高地址中，而数据的低字节保存在内存的低地址中
 *
 *  低地址在左边
 *
 *
 *
 * 基本原理
 *
 *    BitSet是位操作的对象,值只有0或1即false或true, 内部维护了一个long数组，初始只有一个long
 *    所以BitSet最小的size是64，当随着存储的元素越来越多，BitSet内部会动态扩充，最终内部是由Ngelong来存储
 *    这些针对操作都是透明的
 *
 *
 * 使用场景
 *    常见的应用是那些需要对海量数据进行一些统计工作的时候，比如日志分析，用户数统计等等
 *    如统计40亿个数据中没有出现的数据，将40亿个不同数据进行排序等
 *    现在有一千万个随机数，随机数的范围在1到1亿之间。现在要求写出一种算法，将1到1亿之间没有在随机数
 *    中的数求出来
 *
 *
 *
 *
 *
 */
public class BitSetTest {
  @Test
  public void test001() {
    /**
     * 创建对象，该构造方法接收一个int来指明位集合的长度
     * 注意，此时所有位的值都是false，这里的false不是java中的概念，而是对应的bit的0，true对应1
     */
   BitSet set = new BitSet(10); //10 bits set

    //set() 设为true
    set.set(0);
    set.set(1);
    set.set(5);
    System.out.println(set);//它通过集合的方式打印，打印出集合中是true的下标的集合
    System.out.println(Arrays.toString(set.toByteArray()));//打印出这个bit序列所代表的十进制的值
    System.out.println(Arrays.toString(set.toLongArray()));//和上一行的代码打印的内容是相同的
  }

  @Test
  public void test002() {
    /**
     * 90
     * 101 1010
     */
    BitSet set = BitSet.valueOf(new byte[]{90});
    System.out.println(set);

  }
  @Test
  public void test003() {
    BitSet set001 = BitSet.valueOf(new byte[]{90});
    System.out.println(set001);
    BitSet set002 = BitSet.valueOf(new byte[]{90,92,95,97});
    System.out.println(set002);
    /**
     * 运行结果
     *
     * {1, 3, 4, 6}
     * {1, 3, 4, 6, 10, 11, 12, 14, 16, 17, 18, 19, 20, 22, 24, 29, 30}
     */
  }

  @Test
  public void test004() {
    Util.containChars("you don't give then there's no limitation");
  }
}






















