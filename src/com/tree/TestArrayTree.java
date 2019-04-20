package com.tree;

public class TestArrayTree {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7};
        ArrayTree arrayTree = new ArrayTree(array);
        arrayTree.frontShow(0);
    }
}
