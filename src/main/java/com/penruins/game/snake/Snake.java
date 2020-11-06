package com.penruins.game.snake;

import lombok.Getter;
import lombok.Setter;

import java.util.LinkedList;

@Getter
@Setter
public class Snake {
    private LinkedList<Node> body;
    private Direction direction = Direction.LEFT;
    Node head;
    private boolean isAlive = true;

    public Snake() {
        initSnake();
    }

    private void initSnake() {
        body = new LinkedList<>();
        body.add(new Node(16,20));
        body.add(new Node(17,20));
        body.add(new Node(18,20));
        body.add(new Node(19,20));
        body.add(new Node(20,20));
        body.add(new Node(21,20));
    }
    public void move() {
        if(isAlive) {
            head = body.getFirst();
            switch (direction) {
                case UP:
                    body.addFirst(new Node(head.getX() , (head.getY() - 1) ));
                    break;
                case DOWN:
                    body.addFirst(new Node(head.getX(), head.getY() + 1));
                    break;
                case LEFT:
                    body.addFirst(new Node(head.getX() - 1, head.getY()));
                    break;
                case RIGHT:
                    body.addFirst(new Node(head.getX() + 1, head.getY()));
                    break;
            }
            body.removeLast();


            head = body.getFirst();
            //撞墙判断
            if(head.getX() < 0 || head.getY() < 0 || head.getX() >=40 || head.getY() >=40) {
                isAlive = false;
            }
            //追尾判断
            for(int i=1;i<body.size();i++) {
                Node node = body.get(i);
                if(head.getX() == node.getX() && head.getY() == node.getY()) {
                    isAlive = false;
                }
            }
        }
    }

    public void eat(Node food) {
        switch (direction) {
            case UP:
                body.addFirst(new Node(head.getX(), head.getY() - 1));
                break;
            case DOWN:
                body.addFirst(new Node(head.getX(), head.getY() + 1));
                break;
            case LEFT:
                body.addFirst(new Node(head.getX() - 1, head.getY()));
                break;
            case RIGHT:
                body.addFirst(new Node(head.getX() + 1, head.getY()));
                break;
        }
    }
}
