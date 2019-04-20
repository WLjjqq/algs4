package com.tree;

/**
 * 创建一个树。是链式的
 */
public class Tree {
    TreeNode root;

    public TreeNode getRoot() {
        return root;
    }

    public void setRoot(TreeNode root) {
        this.root = root;
    }
    //前序遍历
    public void frontShow(){
        if(root !=null){
            root.frontShow();
        }
    }
    //中序遍历
    public void midShow(){
        if(root != null){
            root.midShow();
        }
    }
    //后序遍历
    public void afterShow(){
        if(root != null){
            root.afterShow();
        }
    }
    //查找
    public TreeNode frontSearch(int i){
            return root.frontSearch(i);
    }

    //删除
    public void delete(int i) {
        if(root.value == i){
            root = null;
        }else {
            root.delete(i);
        }
    }
}
