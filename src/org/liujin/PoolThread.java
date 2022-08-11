package org.liujin;

import java.util.concurrent.*;

/**
 * @author LiuJin
 * @date 2022-07-26 16:17
 */
public class PoolThread {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        MyPoolThread myPoolThread = new MyPoolThread();
        //executorService.execute(myPoolThread);
        //executorService.execute(myPoolThread);
        FutureTask<Integer> futureTask = new FutureTask<Integer>(new MyPoolThread2());
        executorService.submit(futureTask);
        try {
            Integer sum = futureTask.get();
            System.out.println(sum);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }
        executorService.shutdown();
    }
}
class MyPoolThread implements Runnable {
    private int i = 0;
    private boolean isFlag = true;
    @Override
    public void run() {
        while (isFlag) {
            show();
        }
    }
    public synchronized void show() {
        if (i < 10000) {
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName()+": "+i);
                i++;
            }
        } else {
            isFlag = false;
        }
    }
}

class MyPoolThread2 implements Callable<Integer> {
    @Override
    public Integer call() {
        int sum = 0;
        for (int i = 0; i < 10000; i++) {
            if (i % 2 != 0) {
                System.out.println(Thread.currentThread().getName()+": "+i);
                sum += i;
            }
        }
        return sum;
    }
}