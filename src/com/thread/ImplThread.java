package com.thread;

/**
 *  1：使用接口的好处：
 *      因为java是单继承的。但是可以实现多个接口。
 *  2：Thread类中有两个构造函数Thread(Runnable target) 和Thread(Runnable target,String name)。
 *      可以传递Runnable接口。相当于是给Runnable开了一个入口。
 *  3： Thread也实现了Runnable接口。意味着Thread(Runnable target)构造函数不光可以传入Runnable接口的对象。还可以传入一个Thread类的对象。
 *      好处：可以将Thread对象中的run()方法交给其他的线程进行调用。
 *  4：start()方法是：通知“线程规划器”，这个线程已经准备好了。请安排时间去调用这个线程。
 *      调用这个线程的run()方法.不能直接thread.run()。这样相当于是调用了一个run()方法。不是调用线程。
 *      run()是线程的主体。
 *  5：注意一下。继承的方式的话是没有创建线程的。下面的代码只有一个main线程。
 */
public class ImplThread implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i <= 100; i++) {
            System.out.println(Thread.currentThread().getName()+":"+i);
        }
    }

    public static void main(String[] args) {
        ImplThread implThread = new ImplThread();
        Thread thread = new Thread(implThread);
        thread.setName("A线程");
        thread.start();
    }
}
