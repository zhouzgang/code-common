package cn.ecomb.concurrent;

import java.util.concurrent.atomic.AtomicIntegerArray;

/**
 * @author zhouzhigang
 * @date 2017/12/26.
 */
public class Atomic_demo3 {

    static AtomicIntegerArray arr = new AtomicIntegerArray(10);

    public static class AddThread implements Runnable {
        @Override
        public void run() {
            for (int j = 0; j < 100; j++) {
                arr.getAndIncrement(j % arr.length());
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread[] ths = new Thread[10];

        for (int j = 0; j < 10; j++) {
            ths[j] = new Thread(new Atomic_demo3.AddThread());
            ths[j].start();
        }

        for (int j = 0; j < 10; j++) {
            ths[j].join();
        }

        System.out.println(arr);
    }
}
