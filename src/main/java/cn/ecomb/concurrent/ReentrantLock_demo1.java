package cn.ecomb.concurrent;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 重入锁demo
 *
 * @author zhouzhigang
 * @date 2017/12/20.
 */
public class ReentrantLock_demo1 implements Runnable{

    public static ReentrantLock lock = new ReentrantLock();

    public static int i = 0;

    @Override
    public void run() {
        for (int j = 0; j < 2000000; j++) {
            lock.lock();
            lock.lock();
            try {
                i++;
            }finally {
                lock.unlock();
//                lock.unlock();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
//        ReentrantLock_demo1 reentrantLockDemo1 = new ReentrantLock_demo1();
//        Thread t1 = new Thread(reentrantLockDemo1);
//        Thread t2 = new Thread(reentrantLockDemo1);
//        t1.start();
//        t2.start();
//        t1.join();
//        t2.join();
//        System.out.println(i);

        final int[] i = {0};
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int j = 0; j < 2000000; j++) {
                    lock.lock();
                    try {
                        i[0]++;
                        System.out.println("t1:" + i[0]);
                    }finally {
                        lock.unlock();
                    }
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int j = 0; j < 2000000; j++) {
                    lock.lock();
                    try {
                        i[0]++;
                        System.out.println("---> t2:" + i[0]);
                    }finally {
                        lock.unlock();
                    }
                }
            }
        });

        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(i[0]);

    }
}
