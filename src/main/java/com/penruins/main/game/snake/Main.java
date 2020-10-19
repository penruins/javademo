package com.penruins.main.game.snake;


import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.LinkedList;
import java.util.Timer;
import java.util.TimerTask;

public class Main extends JFrame {
    private Snake snake;
    private Timer timer;
    private JPanel jPanel;
    private Node food; //食物
    public Main() {
        initFrame();
        initSnake();
        initFood();
        initGamePanel();
        initTimer();
        setKeyListener();
    }

    private void initFood() {
        food = new Node();
        food.random();
    }

    private void setKeyListener() {
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_U:
                        if(snake.getDirection() != Direction.DOWN) {
                            snake.setDirection(Direction.UP);
                        }
                        break;
                    case KeyEvent.VK_J:
                        if(snake.getDirection() != Direction.UP) {
                            snake.setDirection(Direction.DOWN);
                        }
                        break;
                    case KeyEvent.VK_H:
                        if(snake.getDirection() != Direction.RIGHT) {
                            snake.setDirection(Direction.LEFT);
                        }
                        break;
                    case KeyEvent.VK_K:
                        if(snake.getDirection() != Direction.LEFT) {
                            snake.setDirection(Direction.RIGHT);
                        }
                        break;
                }
            }
        });
    }

    private void initTimer() {
        timer = new Timer();
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                snake.move();

                Node head = snake.getBody().getFirst();
                if(head.getX() == food.getX() && head.getY() == food.getY()) {
                    snake.eat(food);
                    initFood();
                }

                jPanel.repaint();
            }
        };
        timer.scheduleAtFixedRate(timerTask,0,100);

    }

    private void initSnake() {
        snake = new Snake();
    }

    private void initGamePanel() {
        jPanel = new JPanel() {
            @Override
            public void paint(Graphics g) {
                g.clearRect(0,0,600,600);
//                for(int i=0;i<40;i++) {
//                    g.drawLine(0,i*15,600,i*15);
//                    g.drawLine(i*15,0,i*15,600);
//                }
                LinkedList<Node> body = snake.getBody();
                for(Node node : body) {
                    g.fillRect(node.getX()*15,node.getY()*15,15,15);
                }

                g.fillRect(food.getX()*15,food.getY()*15,15,15);
            }
        };
        add(jPanel);


    }

    private void initFrame() {
        setTitle("Snake");
        setSize(610,640);
        setLocation(400,400);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }


    public static void main(String[] args) {
        new Main().setVisible(true);
    }
}
