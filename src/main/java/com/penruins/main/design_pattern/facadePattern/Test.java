package com.penruins.main.design_pattern.facadePattern;

public class Test {
    static Computer computer = new Computer();
    static Light light = new Light();
    static Player player = new Player();
    static PopcornPopper popcornPopper = new PopcornPopper();
    static Projector projector = new Projector();
    static HomeTheaterFacade homeTheaterFacade = new HomeTheaterFacade(computer,player,light,projector,popcornPopper);
    public static void main(String[] args) {
        System.out.println("--- 我现在正准备看电影 ---");

        homeTheaterFacade.watchMovie();

        System.out.println("我正在看「雾中风景」");
        System.out.println("--- 我要结束看电影 ---");

        homeTheaterFacade.stopMovie();


    }
}
