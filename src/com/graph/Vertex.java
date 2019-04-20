package com.graph;

/**
 * 图结构中的顶点。用来存储数据。
 */
public class Vertex {
    private String value;
    //用来标记是否遍历过。
    public boolean visited;
    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Vertex(String value) {
        this.value=value;
    }
}
