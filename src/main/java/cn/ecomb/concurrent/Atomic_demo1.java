package cn.ecomb.concurrent;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * AtomicInteger
 *
 * @author zhouzhigang
 * @date 2017/12/26.
 */
public class Atomic_demo1 {

    static AtomicInteger i = new AtomicInteger();

    public static class AddThread implements Runnable {
        @Override
        public void run() {
            for (int j = 0; j < 10; j++) {
                i.incrementAndGet();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread[] ths = new Thread[10];

        for (int j = 0; j < 10; j++) {
            ths[j] = new Thread(new AddThread());
            ths[j].start();
        }

//        for (int j = 0; j < 10; j++) {
//            ths[j].start();
//        }

        for (int j = 0; j < 10; j++) {
            ths[j].join();
        }

        System.out.println(i);
    }

}
