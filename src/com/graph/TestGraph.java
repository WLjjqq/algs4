package com.graph;

import java.util.Arrays;

public class TestGraph {
    public static void main(String[] args) {
        Vertex vertex1 = new Vertex("A");
        Vertex vertex2 = new Vertex("B");
        Vertex vertex3 = new Vertex("C");
        Vertex vertex4 = new Vertex("D");
        Vertex vertex5 = new Vertex("E");
        Graph graph = new Graph(5);
        graph.addVertex(vertex1); graph.addVertex(vertex2);graph.addVertex(vertex3);
        graph.addVertex(vertex4);
        graph.addVertex(vertex5);
        //增加边
        graph.addEdge("A","C");
        graph.addEdge("B","C");
        graph.addEdge("A","B");
        graph.addEdge("B","D");
        graph.addEdge("B","E");
        for (int[] a : graph.matrix) {
            System.out.println(Arrays.toString(a));
        }

        graph.dfs();
    }
}
