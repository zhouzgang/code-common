package cn.ecomb.concurrent;

/**
 * volatile 变量在并发下一样不安全
 *
 * @author zhouzhigang
 * @date 2017/12/13.
 */
public class Demo1_volatile {
    public static volatile int race = 0;

    public static void increase() {
        race++;
    }

    private static final int THREAD_COUNT = 20;

    public static void main(String[] args) {
        Thread[] threads = new Thread[THREAD_COUNT];
        for (int i=0; i<THREAD_COUNT; i++) {
            threads[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j < 100000; j++) {
                        increase();
                        System.out.println(Thread.currentThread() + "-->" + race);
                    }
                }
            });
            threads[i].start();
        }

        while (Thread.activeCount() > 1) {
            Thread.yield();
        }

        System.out.println("--->" + race);
    }
}
