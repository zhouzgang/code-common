package cn.ecomb.concurrency.appdemo;

/**
 * @author zhouzhigang
 * @date 2018-11-29.
 */
public class DieLikeDog {

    public static void test1() {
        for (; ; ) {
            new Thread(new Runnable() {
                @Override
                public void run() {

                }
            }).start();
        }
    }

    private static Object s = new Object();
    private static int count = 0;

    public static void main(String[] args) {
        for (; ; ) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    synchronized (s) {
                        count += 1;
                        System.err.println("New Thread #" + count);
                    }
                    for (; ; ) {
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }).start();
        }
    }
}
