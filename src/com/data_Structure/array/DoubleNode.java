package com.data_Structure.array;

/**
 * 双链表，双链表有两个节点。记录它上一个是谁，下一个是谁。没有头和尾。是一个循环的
 */
public class DoubleNode {
    //上节点  当只有自己的时候，代表的还是自己。
    DoubleNode pre = this;
    //下节点
    DoubleNode next = this;
    //数据
    int data;

    public DoubleNode(int data) {
        this.data=data;
    }
    //获取数据
    public int getData(){
        return this.data;
    }
    //下一个节点
    public DoubleNode next(){
        return this.next;
    }
    //上一个节点
    public DoubleNode pre(){
        return  this.pre;
    }
    //添加节点
    public void after(DoubleNode node){
        //先获取到下一个节点
        DoubleNode nextNext = next;
        //把新节点作为当前节点的下一个节点。
        this.next=node;
        //把这个添加的节点作为新节点的前一个节点。
        node.pre = this;
        //让原来的节点的下一个节点作新节点的下一个节点。
        node.next = nextNext;
        //让原来的节点的上节点作为新节点。
        nextNext.pre = node;
    }


    public static void main(String[] args) {
        DoubleNode dn1 = new DoubleNode(1);
        DoubleNode dn2 = new DoubleNode(2);
        DoubleNode dn3 = new DoubleNode(3);
        dn1.after(dn2);
        System.out.println(dn2.next.getData());
        System.out.println(dn2.getData());
        System.out.println(dn2.pre.getData());
    }
}
