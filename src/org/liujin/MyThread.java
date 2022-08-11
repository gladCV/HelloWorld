package org.liujin;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 同步代码块
 * @author shkstart
 * @date 2022-07-23 15:46
 */
public class MyThread implements Runnable {
    private int tick = 1000;


    public void run() {
        while (true) {
            synchronized (this) {
                if (tick > 0) {
                    System.out.println(Thread.currentThread().getName()+"窗口购买票号"+tick--);
                } else {
                    break;
                }
            }
        }
    }
}

class ThreadTest {
    public static void main(String[] args) {
//        MyThread myThread = new MyThread();
//        Thread thread1 = new Thread(myThread, "AAAAA");
//        Thread thread2 = new Thread(myThread, "BBBBB");
//        Thread thread3 = new Thread(myThread, "CCCCC");
//        ***********************************************
        MyThread2 thread1 = new MyThread2("AAAAA");
        MyThread2 thread2 = new MyThread2("BBBBB");
        MyThread2 thread3 = new MyThread2("CCCCC");
//        ***********************************************
//        MyThread3 myThread3 = new MyThread3();
//        Thread thread1 = new Thread(myThread3, "AAAAA");
//        Thread thread2 = new Thread(myThread3, "BBBBB");
//        Thread thread3 = new Thread(myThread3, "CCCCC");
//        ***********************************************
//        ThreadLock threadLock = new ThreadLock();
//        Thread thread1 = new Thread(threadLock, "AAAAA");
//        Thread thread2 = new Thread(threadLock, "BBBBB");
//        Thread thread3 = new Thread(threadLock, "CCCCC");
//        thread3.setPriority(10);
//        thread2.setPriority(1);
//        System.out.println(thread1.getState());
//        ***********************************************
//        JoinThread joinThread = new JoinThread();
//        Thread thread1 = new Thread(joinThread, "thread1");
        thread1.start();
        thread2.start();
        thread3.start();
//        System.out.println(thread1.getState());
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//        System.out.println(thread1.getState());
//        for (int i = 0; i < 200; i++) {
//            System.out.println(Thread.currentThread().getName()+":"+i);
//            if (i == 20) {
//                try {
//                    thread1.join();
//                } catch (InterruptedException e) {
//                    throw new RuntimeException(e);
//                }
//            }
//        }
//        System.out.println(thread1.isAlive());
    }
}

/**
 * 继承Thread类-->同步代码块
 */
class MyThread2 extends Thread {
    private static Object object = new Object();
    private int tick = 2000;
    public MyThread2() {

    }
    public MyThread2(String name) {
        super(name);
    }
    public void run() {
        while (true) {
            synchronized (this.getClass()){//synchronized (MyThread2.class){synchronized (object) {
                if (tick > 0) {
                    System.out.println(Thread.currentThread().getName()+"窗口购买票号"+tick--);
                } else {
                    break;
                }
            }
        }
    }
}

/**
 * 实现Runnable接口-->同步方法
 */
class MyThread3 implements Runnable {
    private int tick = 20;
    private boolean isFlag = true;
    public void run() {
        while (isFlag) {
            show();
        }
    }

    public synchronized void show() {
        if (tick > 0) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(Thread.currentThread().getName()+"窗口购票号"+tick--);
            Thread.yield();
        } else {
            isFlag = false;
        }
    }
}

/**
 * 实现Runnable接口-->Lock锁
 */
class ThreadLock implements Runnable {
    private int tick = 20;
    private final ReentrantLock lock = new ReentrantLock();

    public void run() {
        while (true) {
            try {
                lock.lock();
                if (tick > 0) {
                    System.out.println(Thread.currentThread().getName()+"窗口购票号"+tick--);
                } else {
                    break;
                }
            } finally {
                lock.unlock();
            }
        }
    }
}

class JoinThread implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 200; i++) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(Thread.currentThread().getName()+":"+i);
        }
    }
}