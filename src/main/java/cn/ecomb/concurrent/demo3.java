package cn.ecomb.concurrent;

import java.util.Vector;

/**
 * 可以将线程安全分为5个等级
 * 不可变，绝对线程安全，相对线程安全，线程兼容和线程对立
 *
 * 测试线程绝对安全
 * java.util.vector 类标记为线程安全的，也不是线程绝对安全的
 *
 * @author zhouzhigang
 * @date 2017/12/18.
 */
public class demo3 {
    public static Vector<Integer> vector = new Vector<>();

    public static void main(String[] args) {
        while (true) {
            for (int i = 0; i < 10; i++) {
                vector.add(i);
            }

            Thread removeThread = new Thread(new Runnable() {

                @Override
                public void run() {
                    synchronized (vector) {
                        for (int i = 0; i < vector.size(); i++) {
                            vector.remove(i);
                        }
                    }
                }
            });

            Thread printThread = new Thread(new Runnable() {
                @Override
                public void run() {
                    synchronized (vector) {
                        for (int i = 0; i < vector.size(); i++) {
                            System.out.println(vector.get(i));
                        }
                    }
                }
            });

            removeThread.start();
            printThread.start();

            while (Thread.activeCount() > 20) {

            }
        }
    }
}
