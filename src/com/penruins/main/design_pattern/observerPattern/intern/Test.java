package com.penruins.main.design_pattern.observerPattern.intern;

public class Test {
    public static void main(String[] args) {
        SubjectFor3D subjectFor3D = new SubjectFor3D();
        SubjectForSSQ subjectForSSQ = new SubjectForSSQ();

        Observer1 observer1 = new Observer1();
        observer1.registerSubject(subjectFor3D);
        observer1.registerSubject(subjectForSSQ);

        subjectFor3D.setMsg("hello 3d'nums : 110");
        subjectForSSQ.setMsg("ssq'nums : 12,13,31,5,4,3,15");
    }
    /**
     * 可以看出，使用Java内置的类实现观察者模式，代码非常简洁
     * addObserver,removeObserver,notifyObservers都已经为我们实现了，所以可以看出Observable是一个类
     * 而不是一个接口，基本上书上都与java的如此设计抱有反面的态度，觉得Java内置的观察者模式，违反了面向接口编程
     * 这个原则
     */
}
