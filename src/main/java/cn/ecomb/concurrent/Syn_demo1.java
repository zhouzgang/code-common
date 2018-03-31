package cn.ecomb.concurrent;

/**
 * @author zhouzhigang
 * @date 2017/12/20.
 */
public class Syn_demo1 implements Runnable{
    static volatile int i = 0;

    public void increase() {
        i++;
    }

    @Override
    public synchronized void run() {
        for (int j = 0; j < 2000; j++) {
            increase();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Syn_demo1 r1 = new Syn_demo1();
        Syn_demo1 r2 = new Syn_demo1();

//      两个线程执行的是不同的对象，锁加在了不同的对象上，
//      而ReentrantLock_demo 中可以两个线程执行不同的对象，因为重入锁是一个类变量
//        Thread t1 = new Thread(r1);
//        Thread t2 = new Thread(r2);

        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r1);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(i);
    }
}
