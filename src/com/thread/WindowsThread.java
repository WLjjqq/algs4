package com.thread;

public class WindowsThread implements Runnable {
    int ticket = 100;
    @Override
    public void run() {
        while (true) {
            synchronized (this) {
                if (ticket > 0) {
                    try {
                        Thread.currentThread().sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "售票，票号为：" + ticket--);
                } else {
                    break;
                }
            }
        }
    }

    public  static void main(String[] args) {
        WindowsThread windowsThread = new WindowsThread();
        Thread thread1 = new Thread(windowsThread);
        Thread thread2 = new Thread(windowsThread);
        Thread thread3 = new Thread(windowsThread);
        thread1.setName("窗口1");
        thread2.setName("窗口2");
        thread3.setName("窗口3");

        thread1.start();
        thread2.start();
        thread3.start();
    }
}
