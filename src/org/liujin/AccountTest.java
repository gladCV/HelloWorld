package org.liujin;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author LiuJin
 * @date 2022-07-25 16:11
 */
public class AccountTest {
    public static void main(String[] args) {
        Account account = new Account(0);
        Customer c1 = new Customer(account);
        Customer c2 = new Customer(account);
        Customer c3 = new Customer(account);
        Thread t1 = new Thread(c1, "c1");
        Thread t2 = new Thread(c2, "c2");
        Thread t3 = new Thread(c3, "c3");
//        Customer1 c1 = new Customer1(account);
//        Customer1 c2 = new Customer1(account);
//        Customer1 c3 = new Customer1(account);
//        c1.setName("C1");
//        c2.setName("C2");
//        c3.setName("C3");
//        c1.start();
//        c2.start();
//        c3.start();
        t1.start();
        t2.start();
        t3.start();
    }
}

class Account {
    private double balance;
    private final ReentrantLock lock = new ReentrantLock(true);
    public Account(double balance) {
        this.balance = balance;
    }
    private static final Object object = new Object();
//    public synchronized void deposit(double amount) {
//        balance += amount;
//        System.out.println(Thread.currentThread().getName()+":存钱成功。余额为："+balance);
//    }
//********************************************
//    public void deposit(double amount) {
//        synchronized (this) {
//            notify();
//            balance += amount;
//            System.out.println(Thread.currentThread().getName()+":存钱成功。余额为："+balance);
//            try {
//                wait();
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//        }
//    }
//********************************************
    public void deposit(double amount) {
        try {
            lock.lock();
            //this.notify();
            balance += amount;
            System.out.println(Thread.currentThread().getName()+":存钱成功。余额为："+balance);
            //this.wait();
        } finally {
            lock.unlock();
        }

    }
}

class Customer implements Runnable{

    private Account account = null;

    public Customer(Account account) {
        this.account = account;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            account.deposit(1000);
        }
    }
}

class Customer1 extends Thread{

    private Account account = null;

    public Customer1(Account account) {
        this.account = account;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            account.deposit(1000);
        }
        if (Thread.currentThread().isAlive()) {
            System.out.println(Thread.currentThread().getName()+Thread.currentThread().getState());
        }
    }
}