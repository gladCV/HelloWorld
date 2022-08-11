package org.liujin;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * 创建线程方法3：实现Callable接口
 * 步骤：
 * （1）创建实现Callable接口的类，实现call方法
 * （2）创建实现类的对象
 * （3）创建FutureTask类的对象，将（2）中创建的对象作为参数传入到构造器中
 * （4）创建Thread类对象，将（3）中创建的对象作为参数传入到构造器中
 * @author LiuJin
 * @date 2022-07-26 15:29
 */
public class ThreadCall {
    public static void main(String[] args) {
        NewThread newThread = new NewThread();
        FutureTask futureTask = new FutureTask(newThread);
        new Thread(futureTask).start();

        try {
            Object sum = futureTask.get();
            System.out.println("总和为：" + sum);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }
    }
}

class NewThread implements Callable {
    @Override
    public Object call() throws Exception {
        int sum = 0;
        for (int i = 0; i < 20000; i++) {
            if (i%2 == 0) {
                System.out.println(i);
                sum += i;
            }
        }
        return sum;
    }
}


