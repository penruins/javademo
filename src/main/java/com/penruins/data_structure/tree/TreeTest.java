package com.penruins.data_structure.tree;

import org.junit.Test;

public class TreeTest {
    @Test
    public void test() {
        Node<String> root = new Node<String>("A",-1);
        Tree<String> tree = new Tree<>(root);
        Node<String> b = new Node<>("B");
        Node<String> c = new Node<>("C");
        Node<String> d = new Node<>("D");
        Node<String> e = new Node<>("E");
        Node<String> f = new Node<>("F");
        Node<String> g = new Node<>("G");
        tree.add(b,root);
        tree.add(c,root);
        tree.add(d,root);
        tree.add(e,b);
        tree.add(f,b);
        tree.add(g,f);

        System.out.println(tree.getSize());
        System.out.println(tree.getRoot().getData());
        tree.getAllNodes().forEach(ele -> {
            System.out.print(ele.getData() + " ");
        });
        System.out.println();
        tree.add(new Node<String>("H"),g);
        System.out.println(tree.getDepth());
        tree.enlarge();
    }
}
