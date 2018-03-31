package cn.ecomb.concurrent;

/**
 * @author zhouzhigang
 * @date 2018/2/26.
 *
 */
public class SimpleDemo1 {

    public static void main(String[] args) {
        System.out.println("++++>" + Thread.currentThread().getName());
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(0);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("--->t1");
            }
        });
        t1.start();
        System.out.println("=====>" + Thread.currentThread().getName());
    }
}
