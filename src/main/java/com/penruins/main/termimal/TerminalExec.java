package com.penruins.main.termimal;

import lombok.SneakyThrows;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class TerminalExec {
    @SneakyThrows
    public static void main(String[] args) {
        InputStream in = null;
        String[] cmd = new String[]{"ifconfig"};
        Process process = Runtime.getRuntime().exec(cmd);
        in = process.getInputStream();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(in,"UTF-8"));
        String line = null;
        while((line=bufferedReader.readLine()) != null) {
            System.out.println(line);
        }
        int exitValue = process.waitFor();
        System.out.println("return: " + exitValue);
        process.getOutputStream().close();
    }
}
