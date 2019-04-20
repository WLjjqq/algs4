package com.Huffman;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 赫夫曼树：就是最优二叉树。权值越大的结点离根结点越近的二叉树。WPL值最小。
 */
public class HuffmanTree {
    public static void main(String[] args) {
        int arr[] = {3, 7, 8, 29, 5, 11, 23, 14};
        Node node = createHuffmanTree(arr);
        System.out.println(node);
    }
    //创建赫夫曼树。
    public static Node createHuffmanTree(int[] arr){
        //先使用数组中的所有元素。创建若干个二叉树。（只有一个节点）
        List<Node> nodes = new ArrayList<>();
        for (int value : arr) {
            nodes.add(new Node(value));
        }
        //循环处理.要不断的两个相加。然后删除。最后只剩下一个。
        while(nodes.size()>1){
            // 排序
            Collections.sort(nodes);
            //取出权值最小的两个二叉树（左和右）。
            Node left = nodes.get(nodes.size() - 1);
            Node right = nodes.get(nodes.size() - 2);
            //构建一个新的二叉树。
            Node newTree = new Node(left.value + right.value);
            //把取出的那两个删除掉。
            nodes.remove(left);
            nodes.remove(right);
            //放在原来的二叉树集合中。
            nodes.add(newTree);

        }
        return nodes.get(0);
    }
}
