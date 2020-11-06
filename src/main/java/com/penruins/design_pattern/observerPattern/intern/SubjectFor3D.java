package com.penruins.design_pattern.observerPattern.intern;

import java.util.Observable;

/**
 * 3D彩票服务号主题
 */
public class SubjectFor3D extends Observable {
    private String msg;

    public String getMsg() {
        return msg;
    }
    public void setMsg(String msg) {
        this.msg = msg;
        setChanged();
        notifyObservers();
    }
}
