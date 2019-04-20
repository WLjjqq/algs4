package com.test;

public class User {
    public User(){
        System.out.println("第一个构造函数");
    }
    public User(String  string){
        this();
    }
    public static void main(String[] args) {
        User user = new User("HelloWorld");
    }
    }


