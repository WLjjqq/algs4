package com.tree;

/**
 * 顺序存储的二叉树。
 * 1）：顺序存储的二叉树通常只考虑完全二叉树。
 * 2）：第n个元素的左子节点：2n+1
 * 3）：第n个元素的右子节点：2n+2
 * 4）：第n个元素的父节点是：（n-1)/2
 */
public class ArrayTree {
    int[] array;

    public ArrayTree(int[] array) {
        this.array=array;
    }
    //前序遍历
    public void frontShow(int index){
        if(array==null || array.length==0){
            return;
        }
        //先遍历自己
        System.out.println(array[index]);
        //查询左子节点
        if (2 * index+1 < array.length) {
            frontShow(2*index+1);
        }
        //查询右子节点
        if (2 * index + 2 < array.length) {
            frontShow(2*index+2);
        }
    }
}
