package com.thread;

/**
 * 线程的第一种方式。继承父类Thread。并重写run()方法。然后用线程的start()方法去调用。
 */
public class MyThread extends java.lang.Thread {
    public void run(){
        for (int i=0;i<=100;i++) {
            System.out.println(Thread.currentThread().getName()+i);
        }
    }

    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        //setName（） 是设置名字。getName() 是得到名字。
        myThread.setName("子线程：");
        myThread.start();
        //静态的方法，调用当前的线程。
        Thread.currentThread().setName("主线程：");
        for (int i = 0; i < 50; i++) {
            System.out.println(Thread.currentThread().getName()+i);
            if (i == 10) {
                try {
                    //强制把子线程优先获取CPU资源。
                    myThread.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
