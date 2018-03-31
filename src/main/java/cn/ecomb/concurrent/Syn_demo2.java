package cn.ecomb.concurrent;

/**
 * @author zhouzhigang
 * @date 2017/12/20.
 */
public class Syn_demo2 {

    static int i = 0;

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int j = 0; j <2000; j++) {
                    synchronized (Syn_demo2.class) {
                        i++;
                    }
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int j = 0; j <2000; j++) {
                    synchronized (Syn_demo2.class) {
                        i--;
                    }
                }
            }
        });

        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(i);
    }
}
