package com.Huffman;

/**
 * 链表。赫夫曼树结构用到的双链表。
 */
public class Node implements Comparable<Node> {
    //数据
    int value;
    //左儿子
    Node leftNode;
    //右儿子
    Node rightNode;

    public Node(int value) {
        this.value = value;
    }


    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }

    //排序。前面加 - ，是倒序。
    @Override
    public int compareTo(Node o) {
        return -(this.value-o.value);
    }
}
