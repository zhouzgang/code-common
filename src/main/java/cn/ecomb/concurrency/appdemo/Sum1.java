package cn.ecomb.concurrency.appdemo;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * @author zhouzhigang
 * @date 2018/4/24.
 */
public class Sum1 implements Runnable{
    private Sum.ReSum sum;
    private int from;
    private int to;
    private int threadNum;

    private CountDownLatch countDownLatch;

    public Sum1(Sum.ReSum sum, int from, int to, int threadNum, CountDownLatch countDownLatch) {
        this.sum = sum;
        this.from = from;
        this.to = to;
        this.threadNum = threadNum;
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        try {
            long current = System.currentTimeMillis();
            for (int i = from; i <= to; i++) {
                this.sum.v += i;
            }
            current = System.currentTimeMillis() - current;
            System.out.println("from : " + from + "   to : " + to + "  Thread." + threadNum + ": " + sum.v + ", " + current);
            Thread.sleep(3000);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            // 倒数器减1
            countDownLatch.countDown();
        }
    }

    public static void main(String[] args) {

        int max = 100;    // int 的范围
        int sum = 0;
        int threadNum = 4;  // cup 核数

        CountDownLatch countDownLatch = new CountDownLatch(threadNum);

        Sum.ReSum[] subSum = new Sum.ReSum[threadNum];

        long start = System.currentTimeMillis();
        for (int i = 0; i < threadNum; i++) {
            // 非整除的情况
            int from = max * i / threadNum + 1;
            int to = max * (i +1) / threadNum;
            subSum[i] = new Sum.ReSum(0);
            // 这里需要使用去线程池获取线程
            Thread thread = new Thread(new Sum1(subSum[i], from, to, threadNum, countDownLatch));
            thread.start();
        }
        try {
            countDownLatch.await(10, TimeUnit.MILLISECONDS);
            System.out.println(countDownLatch.getCount());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();
        System.out.println("子线程执行时长：" + (end - start));

        for (int i = 0; i < threadNum; i++) {
            sum += subSum[i].v;
        }

        System.out.println("sum: " + sum);
    }

    static class ReSum {
        int v;

        public ReSum(int v) {
            this.v = v;
        }
    }

}
