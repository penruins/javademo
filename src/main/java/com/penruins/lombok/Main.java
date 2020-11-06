package com.penruins.lombok;

import lombok.NonNull;
import lombok.val;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Main {
    @Test
    public void demo1() {
        val sets = new HashSet<String>();
        val lists = new ArrayList<String>();
        val maps = new HashMap<String,String>();
    }

    public void notNullExample(@NonNull String string) {
        string.length();
    }

    /**
     * @Cleanup 自动管理资源，用在局部变量之前，在当前变量范围内即将执行完毕退出之前会自动清理资源
     * 自动生try-finally这样的代码来关闭流
     */
    @Test
    public void demo2() {
        String path = "";
        try {
            InputStream inputStream = new FileInputStream(path);
//            @Cleanup InputStream inputStream = new FileInputStream(path);
        } catch(FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}



















