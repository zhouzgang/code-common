package cn.ecomb.concurrency.producerconsumer;

import java.util.concurrent.TimeUnit;

/**
 * @author zhouzhigang
 * @date 2018/4/17.
 */
public class Test {

    public static void main(String[] args) {
        IBlockingQueue<Integer> queue = new TraditionalBlockingQueue<>();
        Thread producer = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    for (int i = 0; i < 10; i++) {
                        queue.put(1);
                        TimeUnit.MILLISECONDS.sleep(100);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread consumer = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        queue.take();
                        TimeUnit.MILLISECONDS.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        producer.start();
        consumer.start();

    }
}
