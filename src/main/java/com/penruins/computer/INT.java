package com.penruins.computer;

public class INT {
    byte[] data = new byte[32];

    public INT(int data) {

    }

    public INT() {
        for(int i=0;i<data.length;i++) {
            data[i] = 0;
        }
    }

    public byte[] decimal_to_binary(int a) {
        String result = "";
        while(a!=0) {
            result = a%2 + result;
            a/=2;
        }
        byte[] result2 = new byte[32];
        for(int i=0;i<(32-result.length());i++) {
            result2[i] = 0;
        }
        for(int i=0;i<result.length();i++) {
            result2[32-result.length()+i] = Byte.valueOf(String.valueOf(result.charAt(i)));
        }
        return result2;
    }


}
