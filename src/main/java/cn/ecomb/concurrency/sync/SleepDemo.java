package cn.ecomb.concurrency.sync;

import java.time.LocalDateTime;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author zhouzhigang
 * @date 2018/5/22.
 */
public class SleepDemo {

    public static void sleep() {

    }

    public synchronized void t1() {
        System.out.println("----> t1");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized void t2() {
        System.out.println("----> t2");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized void t3() {
        System.out.println("----> t3");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SleepDemo sleepDemo = new SleepDemo();
        System.out.println(LocalDateTime.now());
        ExecutorService es = Executors.newFixedThreadPool(3);
        es.submit(new Runnable() {
            @Override
            public void run() {
                sleepDemo.t1();
            }
        });
        es.submit(new Runnable() {
            @Override
            public void run() {
                sleepDemo.t2();
            }
        });
        es.submit(new Runnable() {
            @Override
            public void run() {
                sleepDemo.t3();
            }
        });

        System.out.println(LocalDateTime.now());

    }

}
