package com.HuffmanBianma;

/**
 *
 */
public class Node implements Comparable<Node> {
    //存的字符。因为我们创建的赫夫曼树，要统计每个字符出现的次数。
    Byte data;
    //结点的权值,就是出现的次数。
    int weight;
    //左结点
    Node left;
    //右结点
    Node right;

    public Node(Byte data, int weight) {
        this.data = data;
        this.weight = weight;
    }

    @Override
    public int compareTo(Node o) {
        return o.weight-this.weight;
    }

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                ", weight=" + weight +
                '}';
    }
}
