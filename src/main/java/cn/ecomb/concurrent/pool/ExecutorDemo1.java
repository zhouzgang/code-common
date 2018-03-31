package cn.ecomb.concurrent.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author zhouzhigang
 * @date 2018/2/27.
 *
 */
public class ExecutorDemo1 {

    public static void main(String[] args) {
//        ExecutorService es1 = Executors.newCachedThreadPool();
//        ExecutorService es1 = Executors.newFixedThreadPool(15);
//        ExecutorService es1 = Executors.newScheduledThreadPool(5);
        ExecutorService es1 = Executors.newSingleThreadExecutor();

        for (int i = 0; i < 5; i++) {
            es1.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println("--->" + Thread.currentThread().getName());
                }
            });
            System.out.println("---->" + i);
        }

        es1.shutdown();
    }

}
