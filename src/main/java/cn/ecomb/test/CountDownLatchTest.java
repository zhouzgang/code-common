package cn.ecomb.test;

import org.junit.Before;
import org.junit.Test;

import java.util.concurrent.*;

/**
 * @author zhouzhigang
 * @date 2018/6/22.
 */
public class CountDownLatchTest {
    private int threadNum = 5;//执行任务的子线程数量
    private int workNum = 20;//任务数量
    private ExecutorService service;
    private ArrayBlockingQueue<String> blockingQueue;
    private CountDownLatch latch;

    @Before
    public void setUp() {
        service = Executors.newFixedThreadPool(threadNum, Executors.defaultThreadFactory());
        blockingQueue = new ArrayBlockingQueue<>(workNum);
        for (int i = 0; i < workNum; i++) {
            blockingQueue.add("任务-" + i);
        }
        latch = new CountDownLatch(workNum);//计数器的值为任务的数量
    }

    @Test
    public void test() throws InterruptedException {
        System.out.println("主线程开始运行");
        for (int i = 0; i < workNum; i++) {
            service.execute(new WorkRunnable());
        }
        latch.await();//等待子线程的所有任务完成
        System.out.println("主线程去做其它事");
    }

    //用blockQueue中的元素模拟任务
    public String getWork() {
        return blockingQueue.poll();
    }

    class WorkRunnable implements Runnable {

        public void run() {
            String work = getWork();
            performWork(work);
            latch.countDown();//完成一个任务就调用一次
        }
    }

    private void performWork(String work) {
        System.out.println("处理任务：" + work);
        try {
            //模拟耗时的任务
            Thread.currentThread().sleep(600);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
