package com.penruins.data_structure.tree;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Node<T>{
    private T data;
    private int parent;

    public Node() {

    }
    public Node(T data) {
        this.data = data;
    }

    public Node(T data, int parent) {
        this.data = data;
        this.parent = parent;
    }
}
