package com.penruins.main.termimal;

import lombok.SneakyThrows;
import org.junit.Test;

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

    /**
     * 将上面的代码进行封装
     * @param command
     * @return
     */
    @SneakyThrows
    public static String termianlExecute(String command) {
        StringBuffer stringBuffer = new StringBuffer();
        Process process = Runtime.getRuntime().exec(command);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(process.getInputStream(),"UTF-8"));
        String line = null;
        while((line=bufferedReader.readLine()) != null) {
            stringBuffer.append(line + "\n");
        }
        return stringBuffer.toString();
    }

    @Test
    public void test() {
        String result = termianlExecute("figlet hello");
        System.out.println(result);
    }
}
