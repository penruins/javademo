package com.penruins.basic.string.algorithm;

public class Main {
    /**
     * 判断一个字符串中，某个字符只有一个
     * @param data
     * @param c
     * @return
     */
    public static boolean onlyOnceString(String data,char c) {
        if(indexOf(data,c) == lastIndexOf(data,c)) {
            return true;
        } else {
            return false;
        }
    }

    public static int indexOf(String s, char c) {
        for(int i=0;i<s.length();i++) {
            if(s.charAt(i) == c) {
                return i;
            }
        }
        return -1;
    }

    public static int lastIndexOf(String s, char c) {
        for(int i=s.length()-1;i>=0;i--) {
            if(s.charAt(i) == c) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 反转录入字符串
     * @param s
     * @return
     */
    public static String reverseString(String s) {
        String result = "";
        for(int i=s.length()-1;i>=0;i--) {
            result += s.charAt(i);
        }
        return result;
    }

    public static String toUpperCase(String s) {
        return s.toUpperCase();
    }


}
