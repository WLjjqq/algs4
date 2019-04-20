package com.data_Structure.array;

/**
 * 单链表
 */
public class Node {
    //存储一个数据。
    int data;
    //存储下一个节点的地址。
    Node next;

    public Node(int data) {
        this.data=data;
    }

    //获取下一个节点
    public Node next(){
        return this.next;
    }
    //获取数据
    public int getData(){
        return this.data;
    }

    //追加节点
    public Node append(Node node) {
        //当前节点
        Node currentNode = this;
        //循环向后找
        while(true){
            Node nextNode = currentNode.next;
            //如果下一个节点为null，当前节点已经是最后一个节点。
            if (nextNode == null) {
                break;
            }
            //不是最后一个。赋值给当前节点。
            currentNode = nextNode;
        }
        //把需要追加的节点追加为找到的当前节点的下一个节点
        currentNode.next=node;
        return this;
    }

    //显示一下所有的节点信息
    public void show(){
        Node currentNode = this;
        while (true) {
            System.out.print(currentNode.data + " ");
            //取出下一个节点
            currentNode = currentNode.next;
            if(currentNode==null){
                break;
            }
        }
    }
    //删除一个节点。删除的是它的后面。删除节点是找到上一个节点。然后把上一个节点的下 下节点赋值给这个上一个节点。
    public void remove(){
        //取出下下节点
        Node newNext = next.next;
        //把下下节点赋值给上一个节点的下个节点。
        this.next=newNext;
    }

    //添加一个节点。添加到它后面。
    public void add(Node node){
        //取出下一个节点。作为下下节点
        Node nextNext = next;
        //然后把新节点作为下一个节点。
        this.next=node;
        //把下下节点作为新节点的下一个节点。
        node.next=nextNext;
    }

    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        node1.append(node2).append(node3).append(node4);
        //node1的下下下一个是node4。输出的结果：4.
        System.out.println(node1.next().next().next().getData());
        node1.show(); //输出结果：1  2  3  4
        node1.next.add(new Node(5));
        System.out.println();
        node1.show(); //添加了一个5  输出结果：1  2  5  3  4
    }
}
