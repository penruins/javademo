package com.penruins.design_pattern.facadePattern;

public class HomeTheaterFacade {
    private Computer computer;
    private Player player;
    private Light light;
    private Projector projector;
    private PopcornPopper popper;

    public HomeTheaterFacade(Computer computer, Player player, Light light, Projector projector, PopcornPopper popper) {
        this.computer = computer;
        this.player = player;
        this.light = light;
        this.projector = projector;
        this.popper = popper;
    }


    public void watchMovie() {
        popper.on();
        popper.makePopcorn();
        light.down();
        projector.on();
        projector.open();
        computer.on();
        player.on();
        player.make3DListener();
    }

    public void stopMovie() {
        popper.stopMakePopcorn();
        popper.off();
        light.up();
        projector.off();
        projector.close();
        player.off();
        computer.off();

    }
}
