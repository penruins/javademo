package com.penruins.io;

import java.io.File;

/**
 * 打印目录树状图结构
 */
public class Main {
    public static void main(String[] args) {
        File f = new File("/Users/penruins/Desktop/code/JDBCDemo/src");
        printFile(f,0);
    }
    static void printFile(File file, int level) {
        for(int i=0;i<level;i++) {
            System.out.print("-");
        }
        System.out.println(file.getName());
        if(file.isDirectory()) {
            File[] files = file.listFiles();
            for(File temp : files) {
                printFile(temp,level+1);
            }
        }
    }

}
