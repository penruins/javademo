package com.penruins.algorithm;


import org.junit.Test;

/**
 * 给定一个整数数组，调整数组中数的顺序，使得所有奇数都位于数组的前半部分
 * 所有偶数位于数组的后半部分
 * 要求时间复杂度为O(n)
 */
public class OddEvenSort {
    /**
     * 解法1 一头一尾指针往中间扫描
     * @param a
     */
    public static void getOddEvenSort1(int[] a) {
        if(a.length == 1) {
            return;
        }
        int begin = 0;
        int end = a.length - 1;
        while(begin < end) {
            if(a[begin] % 2 == 1) {
                begin++;
            } else if(a[end] % 2 == 0) {
                end --;
            } else {
                swap(a,begin,end);
            }
        }
    }

    /**
     * 一前一后两指针往后扫描
     * @param a
     */
    public static void getOddEvenSort2(int[] a) {
        if(a.length == 1) {
            return;
        }
        /**
         * 定义标准元素位置，最终结果是在该元素值的左边都是奇数
         * 在该元素值的右边都是偶数
         */
        int origin = 0;
        int i = 0;
        for(int j=1;j<a.length;j++) {
            /**
             * 当A[j]为奇数时，右移一位，并交换A[i]和A[j]值，表明
             * 在i的左边均为奇数
             */
            if(a[j] % 2 == 1) {
                i++;
                swap(a,i,j);
            }
        }

        swap(a,i,origin);
    }

    private static void swap(int[] a,int m, int n) {
        int temp = a[m];
        a[m] = a[n];
        a[n] = temp;
    }

    @Test
    public void test1() {
        int[] a = {2,1,4,7,1,4,7,1,2,8,4,3,6,7,2,14,3,7,4,3,2,4,3,2,7};
        getOddEvenSort1(a);
        System.out.println("使用方法1： 一头一尾指针往中间扫描结果：");
        for(int i=0;i<a.length;i++) {
            System.out.print(a[i] + " ");
        }
    }
}
