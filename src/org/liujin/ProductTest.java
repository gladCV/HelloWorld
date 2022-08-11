package org.liujin;

/**
 * @author LiuJin
 * @date 2022-07-25 17:22
 */
class Clerk {
    private int number;

    public Clerk(int number) {
        this.number = number;
    }
    public synchronized void produceProduct() {
        if (number < 200) {
            if (number == 0) {
                number++;
            }
            System.out.println(Thread.currentThread().getName()+":正在生产第"+number+"个产品");
            if (number > 0) {
                number++;
            }
            notify();
        } else {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public synchronized void consumeProduct() {
        if (number > 0) {
            System.out.println(Thread.currentThread().getName()+":正在消费第"+number+"个产品");
            number--;
            notify();
        } else {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
class Consumer implements Runnable {
    private Clerk clerk;
    public Consumer(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
        while (true) {
//            try {
//                Thread.sleep(50);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
            clerk.consumeProduct();
        }
    }
}
class Producer implements Runnable {
    private Clerk clerk;
    public Producer(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
        while (true) {
//            try {
//                Thread.sleep(50);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
            clerk.produceProduct();
        }
    }
}

public class ProductTest {
    public static void main(String[] args) {
        Clerk clerk = new Clerk(100);
        Consumer consumer = new Consumer(clerk);
        Producer producer = new Producer(clerk);
        Thread t1 = new Thread(consumer, "消费者");
        Thread t2 = new Thread(producer, "生产者");
        t1.start();
        t2.start();

    }
}