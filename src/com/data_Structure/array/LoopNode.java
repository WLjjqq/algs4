package com.data_Structure.array;

/**
 * 循环链表
 */
public class LoopNode {
    //存储一个数据。
    int data;
    //存储下一个节点的地址。当只有一个结点的时候，自己指向自己
    LoopNode next = this;
    public LoopNode(int data) {
        this.data=data;
    }
     //获取数据
    public int getData(){
        return this.data;
    }
    //删除一个节点。删除的是它的后面。删除节点是找到上一个节点。然后把上一个节点的下 下节点赋值给这个上一个节点。
    public void remove(){
        //取出下下节点
        LoopNode newNext = next.next;
        //把下下节点赋值给上一个节点的下个节点。
        this.next=newNext;
    }
    //添加一个节点。添加到它后面。
    public void add(LoopNode node){
        //取出下一个节点。作为下下节点
        LoopNode nextNext = next;
        //然后把新节点作为下一个节点。
        this.next=node;
        //把下下节点作为新节点的下一个节点。
        node.next=nextNext;
    }
    public static void main(String[] args) {
        LoopNode node1 = new LoopNode(1);
        LoopNode node2 = new LoopNode(2);
        LoopNode node3 = new LoopNode(3);
        LoopNode node4 = new LoopNode(4);
        node1.add(node2);
        System.out.println(node1.next.getData());
        System.out.println(node2.next.getData());
    }
}
