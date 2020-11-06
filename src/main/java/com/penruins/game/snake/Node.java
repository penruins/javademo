package com.penruins.game.snake;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Random;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Node {
    private int x;
    private int y;

    public void random() {
        Random random = new Random();
        this.x = random.nextInt(40);
        this.y = random.nextInt(40);
    }
}
