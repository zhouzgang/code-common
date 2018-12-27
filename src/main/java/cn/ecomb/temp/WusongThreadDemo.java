package cn.ecomb.temp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 测试线程中的问题
 * Q：
 *  1. 为什么会出现空
 *  2. Thread构造函数接收的 Runnable 的实例
 *  3. int 与 Integer 之间造成的区别
 *  4. Integer 实现原理，特例
 *  5. 查看线程执行过程，threadDump
 * @author zhouzg
 * @date 2018/8/23
 */
public class WusongThreadDemo implements Runnable {

    private int value = 0;

    private List<Integer> list = new ArrayList<>();

    private void value() {
//        try {
//            Thread.sleep(500);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        list.add(++value);
//        System.out.println("print "+ Arrays.asList(list).toString());
//        System.out.println(Thread.currentThread().getId());
        if (list.size() == 50) {
            System.out.println(Arrays.asList(list).toString());
        }
    }

    @Override
    public void run() {
        value();
    }

    public static void main(String[] args) {
        System.out.println("start");
        WusongThreadDemo demo = new WusongThreadDemo();
        for (int i = 0; i < 50; i++) {
            new Thread(demo).start();
        }
    }
}
