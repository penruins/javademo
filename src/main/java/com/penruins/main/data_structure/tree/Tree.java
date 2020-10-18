package com.penruins.main.data_structure.tree;

public class Tree<T> {
    private final int DEFAULT_SIZE = 2;
    private int size;
    private int count;
    private Object[] nodes;

    public Tree() {
        this.size = this.DEFAULT_SIZE;
        this.nodes = new Object[this.size];
        this.count = 0;
    }

    public Tree(Node<T> root) {
        this();
        this.count = 1;
        this.nodes[0] = root;
    }
    
    public Tree(Node<T> root, int size) {
        this.size = size;
        this.nodes = new Object[this.size];
        this.count = 1;
        this.nodes[0] = root;
    }


}
