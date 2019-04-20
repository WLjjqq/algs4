package com.data_Structure.array;

/**
 * 栈
 */
public class Stack {
    int[] elements;
    public Stack(){
        elements = new int[0];
    }
    //压人元素
    public  int[] push(int element){
        //创建一个新的数组
        int[] newArr = new int[elements.length+1];
        //把旧的数组的值赋值到新的数组中
        for(int i=0;i<elements.length;i++){
            newArr[i]=elements[i];
        }
        //添加元素到新的数组中。下标是旧数组的长度
        newArr[elements.length]=element;
        //因为是面向对象的。所以把新数组替换旧数组
        elements=newArr;
        return elements;
    }
    //取出栈顶的元素
    public int pop(){
        //if栈为空
        if(elements.length==0){
            throw new RuntimeException("这个栈为空");
        }
        //先取出栈顶的元素，是数组的最后一个元素，因为是下标从0开始。所以下标是长度-1
        int element=elements[elements.length-1];
        //因为减少了一个元素。所以要重新创建一个数组。然后把减少的那个给删除掉
        int[] newArr=new int[elements.length-1];
        for(int i=0;i<newArr.length;i++){
            newArr[i]=elements[i];
        }
        //替换数组
        elements=newArr;
        return element;
    }

    public static void main(String[] args) {
        Stack stack = new Stack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        for(int i:stack.elements){
            System.out.println("进栈的值："+i);
        }

        System.out.println("出栈的值："+stack.pop());
        System.out.println("出栈的值："+stack.pop());
        System.out.println("出栈的值："+stack.pop());
        System.out.println("出栈的值："+stack.pop());
    }
}
