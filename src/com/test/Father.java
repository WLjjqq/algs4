package com.test;

public class Father {
    public String name;
    public String age;

    public Father() {
        System.out.println("1：父类的无参构造函数");
    }
    public Father(String name){
        System.out.println("2：父类的有参构造函数");
    }
}
