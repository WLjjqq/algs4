package com.java8;

public class HelloWorld {
    public static void main(String[] args) {
        printHello();
    }
   public static void printHello(){
        System.out.println("hello world");
        Runnable runnable=() ->{
            System.out.println("runable");
       };
       Thread thread = new Thread(runnable);
       thread.start();
    }


}
