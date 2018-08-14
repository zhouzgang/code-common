package cn.ecomb.temp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

/**
 * 测试 fork/join 的使用
 * [印象笔记]线程之Java的Fork/Join框架
 * @author zhouzg
 * @date 2018/8/13
 */
public class ForkJoinDemoTask extends RecursiveTask<Long> {

    private static Logger logger = LoggerFactory.getLogger(ForkJoinDemoTask.class);

    private static final long serialVersionUID = 1L;

    long[] data;
    int start;
    int end;

    public ForkJoinDemoTask(long[] data, int start, int end) {
        this.data = data;
        this.start = start;
        this.end = end;
    }

    @Override
    protected Long compute() {
        long sum = 0;
        if (end - start < 1000) {
//            System.out.println("执行参数：" + start + "," + end);
//            logger.info("执行参数：{},{}", start, end);
            for (int i = start; i < end; i++) {
                sum += data[i];
            }
//            对 println() 和 logger 的耗时测试及对比
//            System.out.println(Thread.currentThread().getId() + "-> sum: " + sum);
            logger.info("{}-> sum: {}", Thread.currentThread().getId(), sum);
        } else {
            int middle = (end + start) / 2;
            ForkJoinDemoTask taskLeft = new ForkJoinDemoTask(data, start, middle);
            ForkJoinDemoTask taskRight = new ForkJoinDemoTask(data, middle+1, end);
            taskLeft.fork();
            taskRight.fork();
            sum = taskLeft.join() + taskRight.join();
        }
        return sum;
    }

    public static void main(String[] args) {
        long[] data = new long[1024 * 1024];
        Arrays.setAll(data, i -> i);
        long start = System.currentTimeMillis();
        long sum = new ForkJoinPool().invoke(new ForkJoinDemoTask(data, 0, data.length - 1));
        System.out.println(sum);
        System.out.println("used time：" + (System.currentTimeMillis() - start));
    }
}
