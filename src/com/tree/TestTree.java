package com.tree;

public class TestTree {
    public static void main(String[] args) {
        //创建一个树。
        Tree tree = new Tree();
        //创建根节点
        TreeNode treeNode = new TreeNode(1);
        tree.setRoot(treeNode);
        //创建左儿子
        TreeNode LtreeNode = new TreeNode(2);
        treeNode.setLeftNode(LtreeNode);
        //左儿子再创建第三代的左儿子和右儿子
            //创建左儿子的左儿子
            TreeNode LLtreeNode = new TreeNode(4);
            LtreeNode.setLeftNode(LLtreeNode);
            //创建左儿子的右儿子
            TreeNode RRtreeNode = new TreeNode(5);
            LtreeNode.setRightNode(RRtreeNode);
        //创建右儿子
        TreeNode RtreeNode = new TreeNode(3);
        treeNode.setRightNode(RtreeNode);

        //创建右儿子的左儿子
        TreeNode RLtreeNode = new TreeNode(6);
        RtreeNode.setLeftNode(RLtreeNode);
        //创建右儿子的右儿子
        TreeNode RRRtreeNode = new TreeNode(7);
        RtreeNode.setRightNode(RRRtreeNode);
        //前序遍历
        tree.frontShow();
        System.out.println();
        //中序遍历
        tree.midShow();
        System.out.println();
        //后序遍历
        tree.afterShow();
        System.out.println();

        //前序查找
        TreeNode treeNode1 = tree.frontSearch(10);
        System.out.println(treeNode1);

        //删除
        tree.delete(1);
        tree.frontShow();
    }


}
