package com.penruins.main.data_structure.tree;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

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
    public void add(Node<T> node) {
        for(int i=0;i<this.size;i++) {
            if(this.nodes[i] == null) {
                nodes[i] = node;
                break;
            }
        }
        this.count++;
    }
    public void check() {
        if(this.count >= this.size) {
            this.enlarge();
        }
    }

    public void add(Node<T> node, Node<T> parent) {
        this.check();
        node.setParent(this.position(parent));
        this.add(node);
    }

    //获取节点在数组的存储位置
    public int position(Node<T> node) {
        for(int i=0;i<this.size;i++) {
            if(nodes[i] == node) {
                return i;
            }
        }
        return -1;
    }

    public int getSize() {
        return this.count;
    }

    public Node<T> getRoot() {
        return (Node<T>) this.nodes[0];
    }

    public List<Node<T>> getAllNodes() {
        List<Node<T>> list = new ArrayList<>();
        for(int i=0;i<this.size;i++) {
            if(this.nodes[i] != null) {
                list.add((Node<T>) nodes[i]);
            }
        }
        return list;
    }

    /**
     * 获取树的深度，只有根节点时为1
     */
    public int getDepth() {
        int max = 1;
        if(this.nodes[0] == null) {
            return 0;
        }

        for(int i=0;i<this.count;i++) {
            int deep = 1;
            int location = ((Node<T>)(this.nodes[i])).getParent();
            while(location != -1 && this.nodes[location]!= null) {
                location = ((Node<T>)(this.nodes[location])).getParent();
                deep++;
            }
            if(max < deep) max = deep;
        }
        return max;
    }

    public void enlarge() {
        this.size += this.DEFAULT_SIZE;
        Object[] newNodes = new Object[this.size];
        newNodes = Arrays.copyOf(nodes,this.size);
        Arrays.fill(nodes,null);
        this.nodes = newNodes;
        System.out.println("enlarge");
    }

}
