package com.test;

public class Sun extends Father {

    public Sun(){
        super("Hello");
        System.out.println("无参子类调用父类的有参构造函数");
    }

    public static void main(String[] args) {
        Sun sun = new Sun();

    }
}
