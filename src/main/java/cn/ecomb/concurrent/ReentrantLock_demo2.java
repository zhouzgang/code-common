package cn.ecomb.concurrent;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 重入锁 中断demo
 *
 * @author zhouzhigang
 * @date 2017/12/20.
 */
public class ReentrantLock_demo2 implements Runnable{

    public static ReentrantLock lock1 = new ReentrantLock();
    public static ReentrantLock lock2 = new ReentrantLock();

    int i = 0;

    public ReentrantLock_demo2(int i) {
        this.i = i;
    }

    @Override
    public void run() {
        try {
            if (i == 1) {
                lock1.lockInterruptibly();
                Thread.sleep(500);
                lock2.lockInterruptibly();
            } else {
                lock2.lockInterruptibly();
                Thread.sleep(500);
                lock1.lockInterruptibly();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            if (lock1.isHeldByCurrentThread()) {
                lock1.unlock();
            }
            if (lock2.isHeldByCurrentThread()) {
                lock2.unlock();
            }
            System.out.println(Thread.currentThread().getId() + " 线程退出");
        }

    }

    public static void main(String[] args) throws InterruptedException {
        ReentrantLock_demo2 r1 = new ReentrantLock_demo2(1);
        ReentrantLock_demo2 r2 = new ReentrantLock_demo2(2);
        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r2);
        t1.start();
        t2.start();
        Thread.sleep(500);
        System.out.println(Thread.currentThread().getId());
        Thread.currentThread().join();
    }
}
