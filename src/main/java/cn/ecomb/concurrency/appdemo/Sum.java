package cn.ecomb.concurrency.appdemo;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhouzhigang
 * @date 2018/4/24.
 */
public class Sum implements Runnable{

    private ReSum sum;
    private int from;
    private int to;
    private int threadNum;

    public Sum(ReSum sum, int from, int to, int threadNum) {
        this.sum = sum;
        this.from = from;
        this.to = to;
        this.threadNum = threadNum;
    }

    @Override
    public void run() {
        long current = System.currentTimeMillis();
        for (int i = from; i <= to; i++) {
            this.sum.v += i;
        }
        current = System.currentTimeMillis() - current;
        System.out.println("from : " + from + "   to : " + to + "  Thread." + threadNum + ": " + sum.v + ", " + current);
    }

    public static void main(String[] args) {

        int max = 10000;    // int 的范围
        int sum = 0;
        int threadNum = 4;  // cup 核数

        List<Thread> list = new ArrayList<Thread>();

        ReSum[] subSum = new ReSum[threadNum];
        for (int i = 0; i < threadNum; i++) {
            subSum[i] = new ReSum(0);
        }
        long start = System.currentTimeMillis();
        for (int i = 0; i < threadNum; i++) {
            // 非整除的情况
            int from = max * i / threadNum + 1;
            int to = max * (i +1) / threadNum;

            Thread thread = new Thread(new Sum(subSum[i], from, to, threadNum));
            thread.start();
            list.add(thread);
        }

        for(Thread thread : list)
        {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        long end = System.currentTimeMillis();
        System.out.println("子线程执行时长：" + (end - start));
//        try {
            // sleep等待子线程完成 处理
//            Thread.sleep(10);
            for (int i = 0; i < threadNum; i++) {
                sum += subSum[i].v;
            }

            System.out.println("sum " + sum);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
    }

    static class ReSum {
        int v;

        public ReSum(int v) {
            this.v = v;
        }
    }

}








