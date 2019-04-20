package com.BinarySortTree;

public class Node {
    int value;
    Node left;
    Node right;

    public Node(int value) {
        this.value = value;
    }
    /**
     * 向子树中添加节点
     * @param node
     */
    public void add(Node node) {
        if (node == null) {
            return;
        } else {
            //判断传入的节点的值，与根节点的值相比较。
            if (node.value < this.value) {
                //如果左节点为空
                if (this.left == null) {
                    this.left = node;
                } else {
                    this.left.add(node);
                }
            } else {
                if (this.right == null) {
                    this.right = node;
                } else {
                    this.right.add(node);
                }
            }
        }
    }
    /**
     * 中序遍历
     * @param node
     */
    public void midShow(Node node) {
        if (node == null) {
            return;
        }
        midShow(node.left);
        System.out.println(node);
        midShow(node.right);
    }
    /**
     * 查询
     * @param value
     * @return
     */
    public Node search(int value) {
        if (this.value == value) {
            return this;
        } else if (value < this.value) {
            //如果小于，去左边查找
            //如果左边的为空，直接就返回一个null
            if (left == null) {
                return null;
            }
            return left.search(value);
        } else {
            if (right == null) {
                return null;
            }
            return right.search(value);
        }
    }
    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }

    /**
     * 查找父节点
     *
     * @param value
     * @return
     */
    public Node searchParent(int value) {
        if ((this.left != null && this.left.value == value) || (this.right != null && this.right.value == value)) {
            return this;
        } else {
            if (this.left != null && this.value > value) {
                return this.left.searchParent(value);
            } else if (this.right != null && this.value < value) {
                return this.right.searchParent(value);
            }
        }
        return null;
    }

    /**
     * 查看树的高度
     * @return
     */
    public int height(){
     return Math.max(left == null ? 0 : left.height(), right == null ? 0 : right.height()) + 1;
    }
}
