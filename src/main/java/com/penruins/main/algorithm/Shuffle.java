package com.penruins.main.algorithm;

import java.util.Random;

/**
 * 红桃 1~13
 * 方块 14~26
 * 黑桃 27~39
 * 梅花 40~52
 * 小王 53 大王 54
 */
public class Shuffle {
    public static void main(String[] args) {
        int[] total = new int[108];
        int[][] player = new int[4][25];
        int leftNum = 108;
        int ranNumber;
        Random random = new Random();
        for(int i=0;i<total.length;i++) {
            total[i] = (i+1) % 54;
            if(total[i] == 0) {
                total[i] = 54;
            }
        }
        for(int i=0;i<25;i++) {
            for(int j=0;j<player.length;j++) {
                ranNumber = random.nextInt(leftNum);
                player[j][i] = total[ranNumber];
                total[ranNumber] = total[leftNum-1];
                leftNum--;
            }
        }
        for(int i=0;i<player.length;i++) {
            for(int j=0;j<25;j++) {
                System.out.print(" " + player[i][j]);
            }
            System.out.println();
        }
    }
}
