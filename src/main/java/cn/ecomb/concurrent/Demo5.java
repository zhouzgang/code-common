package cn.ecomb.concurrent;

import java.util.concurrent.TimeUnit;

/**
 * @author zhouzhigang
 * @date 2017/12/20.
 */
public class Demo5 implements Runnable{

    public synchronized void f() {
        System.out.println("try to call f()");
        while (true) {
            Thread.yield();
        }
    }

    public Demo5() {
        new Thread(){
            @Override
            public void run() {
                f();
            }
        }.start();
    }

    @Override
    public void run() {
        while (true) {
            if (Thread.interrupted()) {
                System.out.println("中断线程");
                break;
            } else {
                f();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Demo5 r1 = new Demo5();
        Thread t1 = new Thread(r1);
        t1.start();
        TimeUnit.SECONDS.sleep(1);
        t1.interrupt();
    }
}
