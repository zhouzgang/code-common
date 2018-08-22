package cn.ecomb.temp;

/**
 * @author zhouzg
 * @date 2018/8/14
 */
public class ThreadJoinDemo implements Runnable{

    @Override
    public void run() {
        try {
            Thread.sleep(1000);
            while (true) {
                System.out.println(Thread.currentThread().getId());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new ThreadJoinDemo());
        Thread t2 = new Thread(new ThreadJoinDemo());
        t1.start();
        t2.start();
        t1.join();
    }
}
