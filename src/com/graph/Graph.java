package com.graph;

import java.util.Stack;

/**
 * 图结构的一个图类。用来关联各个顶点的关系。
 */
public class Graph {
    //用来存放顶点
    private Vertex[] vertices;

    //用来村放顶点的下标
    private int currentSize;
    //用来存放两个顶点间是否有边。
    public int[][] matrix;
    //深度优先算法遍历其实是压入栈中。
    Stack stack = new Stack();
    //当前遍历的下标
    public int currentIndex;

    public Graph(int size) {
        vertices = new Vertex[size];
        matrix = new int[size][size];
    }

    /**
     * 向图中加入一个节点
     * @param vertex
     */
    public void addVertex(Vertex vertex) {
        vertices[currentSize++]=vertex;
    }

    /**
     * 顶点与顶点间添加边，就是用到矩阵，二维数组就是一个矩阵。两个顶点间有边。就写1.
     * @param v1
     * @param v2
     */
    public void addEdge(String v1, String v2) {
        int index1=0,index2=0;
        for (int i = 0; i < vertices.length; i++) {
            if (vertices[i].getValue().equals(v1)) {
                index1 = i;
                break;
            }
        }
        for (int i = 0; i < vertices.length; i++) {
            if (vertices[i].getValue().equals(v2)) {
                index2 = i;
                break;
            }
        }
        matrix[index1][index2]=1;
        matrix[index2][index1]=1;
    }

    /**
     * 深度优先搜索算法遍历
     */
    public void dfs() {
        //先遍历的是下标为0的顶点。
        vertices[0].visited=true;
        //把下标0压入栈中。
        stack.push(0);
        //打印下标为0的顶点的值。
        System.out.println(vertices[0].getValue());
        //遍历
        out:while (!stack.isEmpty()) {
            for (int i = currentIndex+1; i < vertices.length; i++) {
                //如果下一个与当前的有边。并且还没有遍历过。
                if (matrix[currentIndex][i]==1 && vertices[i].visited == false) {
                    // 把下一个元素压入栈中。
                    stack.push(i);
                    //标记第i个已经访问了。
                    vertices[i].visited=true;
                    System.out.println(vertices[i].getValue());
                    continue out;
                }
            }
            //如果与之没有相关联的边。就弹出栈顶的元素。
            stack.pop();
            //修改当前位置为栈顶元素的位置。
            if (!stack.isEmpty()) {
                currentIndex=(int)stack.peek();
            }
        }
    }
}
