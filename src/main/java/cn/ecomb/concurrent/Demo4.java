package cn.ecomb.concurrent;

import java.util.concurrent.TimeUnit;

/**
 * 中断 demo
 *
 * @author zhouzhigang
 * @date 2017/12/20.
 */
public class Demo4 {

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread() {
            @Override
            public void run() {
                try {
                    while (true) {
                        System.out.println("阻塞。。。");
                        TimeUnit.SECONDS.sleep(3);
                    }
                } catch (InterruptedException e) {
                    System.out.println("Sleep");
                    boolean interrupt = this.isInterrupted();
                    System.out.println(interrupt);
                }
            }
        };

        t1.start();

//        TimeUnit.SECONDS.sleep(3);

        t1.isInterrupted();
    }

}
