package com.tree;

/**
 * 创建一个树。这个树是链式结构的。
 */
public class TreeNode {
    //树中链式结构的值。
    int value;
    //左儿子
    TreeNode leftNode;
    //右儿子
    TreeNode rightNode;

    public TreeNode(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public TreeNode getLeftNode() {
        return leftNode;
    }

    public void setLeftNode(TreeNode leftNode) {
        this.leftNode = leftNode;
    }

    public TreeNode getRightNode() {
        return rightNode;
    }

    public void setRightNode(TreeNode rightNode) {
        this.rightNode = rightNode;
    }

    //前遍历
    public void frontShow(){
        //自己放在第一个进行遍历
        System.out.print(value);
        //左节点
        if(leftNode!=null){
            leftNode.frontShow();
        }
        //右节点
        if (rightNode != null) {
            rightNode.frontShow();
        }
    }

    //中遍历
    public void midShow(){
        //左节点
        if(leftNode!=null){
            leftNode.midShow();
        }
        //自己放在中间进行遍历
        System.out.print(value);
        //右节点
        if (rightNode != null) {
            rightNode.midShow();
        }
    }

    //后遍历
    public void afterShow(){
        //左节点
        if(leftNode!=null){
            leftNode.afterShow();
        }
        //右节点
        if (rightNode != null) {
            rightNode.afterShow();
        }
        //自己放在最后进行遍历
        System.out.print(value);
    }

    //前序查找
    public TreeNode frontSearch(int i) {
        TreeNode treeNode = null;
        //先和自己进行比较。如果值相同的话，就直接返回就行了。
        if(this.value == i){
            return this;
        }
        //左儿子。和左节点进行比较。如果有左节点。然后去查找。
        if(leftNode != null){
            treeNode = leftNode.frontSearch(i);
        }
        //返回的值不为null，就是找到了。
        if(treeNode!=null){
            return treeNode;
        }
        //右儿子。左边的没有找到。找右边的。
        if(rightNode!=null){
            treeNode = rightNode.frontSearch(i);
        }
        return treeNode;
    }

    //删除。
    public void delete(int i){
        //先判断要删除的是不是自己。
        TreeNode deleteTreeNode = this;
        //左叶子。
        if(deleteTreeNode.leftNode!=null && deleteTreeNode.leftNode.value==i){
            deleteTreeNode.leftNode = null;
            return;
        }
        //右叶子。
        if(deleteTreeNode.rightNode!=null && deleteTreeNode.rightNode.value==i){
            deleteTreeNode.rightNode = null;
            return;
        }
        //看看要删除的是不是左叶子的两个左右节点。
        deleteTreeNode = leftNode;
        if(deleteTreeNode != null){
            deleteTreeNode.delete(i);
        }
        deleteTreeNode = rightNode;
        if(deleteTreeNode != null){
            deleteTreeNode.delete(i);
        }
    }
}
