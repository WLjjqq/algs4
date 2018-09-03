package com.algorithms.chapter1.chapter1_1;

/**
 * 编写一个程序，从命令行得到三个整数参数。如果它们都相等则打印 equal，否则打印 not equal
 */
public class exercises1_1_3 {

    public static void main(String[] args) {
        args= new String[]{"2","2","2"};
        String str=args[0].equals(args[1]) && args[1].equals(args[2])?"equal":"not equal";
        System.out.println(str);
        boolean a=true;
        boolean b=false;
        if(a&&b){
            System.out.println("if后面跟的是true &&:是两个都要为真");
        }else if(b || a){
            System.out.println("||的值：只有一个为真就行");
        }
    }
}
