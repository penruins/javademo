package com.penruins.main.design_pattern.observerPattern;

/**
 * 主题接口，所有的主题必须实现此接口
 */
public interface Subject {
    /**
     * 注册一个观察者
     * @param observer
     */
    public void registerObserver(Observer observer);


    /**
     * 移除一个观察者
     * @param observer
     */
    public void removeObserver(Observer observer);

    /**
     * 通知所有的观察者
     */
    public void notifyObservers();

}
