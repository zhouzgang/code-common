package cn.ecomb.clazz;

/**
 * VM 保证 类的<clint>()在多线程环境下正确加锁，同步
 * @author zhouzhigang
 * @date 2017/12/7.
 */
public class Demo4 {

    static {
        if (true) {
            System.out.println(Thread.currentThread() + "Init Demo4");
            while (true) {

            }
        }
    }

    public static void main(String[] args) {
        Runnable script = new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread() + "Start");
                Demo4 demo4 = new Demo4();
                System.out.println(Thread.currentThread() + "run over");
            }
        };
        Thread t1 = new Thread(script);
        t1.start();
        Thread t2 = new Thread(script);
        t2.start();
    }
}
