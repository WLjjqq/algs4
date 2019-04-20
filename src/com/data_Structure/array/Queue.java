package com.data_Structure.array;

/**
 * 队列的学习。
 */
public class Queue {
    int[] elements;
    public Queue(){
        elements = new int[0];
    }
    //进队
    public  int[] add(int element){
        //创建一个新的数组
        int[] newArr = new int[elements.length+1];
        //把旧的数组的值赋值到新的数组中
        for(int i=0;i<elements.length;i++){
            newArr[i]=elements[i];
        }
        //每次进队的时候，都是在队尾。
        newArr[elements.length]=element;
        //因为是面向对象的。所以把新数组替换旧数组
        elements=newArr;
        return elements;
    }

    //出队
    public int poll(){
        //因为出队的时候，每次都是队头的元素。
        int element = elements[0];
        //创建数组，然后把旧的放到新创建的数组中。
        int[] newArr=new int[elements.length-1];
        for(int i=0;i<newArr.length;i++){
            newArr[i]=elements[i+1];
        }
        //替换
        elements=newArr;
        return element;
    }

    public static void main(String[] args) {
        Queue queue = new Queue();
        queue.add(9);
        queue.add(8);
        queue.add(7);

        for (int i : queue.elements) {
            System.out.println("入队的元素："+i);
        }
        System.out.println("出队的元素："+queue.poll());
        queue.add(10);
        System.out.println("出队的元素："+queue.poll());
        System.out.println("出队的元素："+queue.poll());
    }
}
