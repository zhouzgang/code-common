package cn.ecomb.temp;

import java.util.Arrays;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

/**
 * 测试 fork/join 的使用
 *
 * @author zhouzg
 * @date 2018/8/13
 */
public class ForkJoinDemoTask extends RecursiveTask<Long> {

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
            for (int i = start; i < end; i++) {
                sum += data[i];
            }
        } else {
            int middle = (end - start) / 2;
            ForkJoinDemoTask taskLeft = new ForkJoinDemoTask(data, start, middle);
            ForkJoinDemoTask taskRight = new ForkJoinDemoTask(data, middle, end);
            taskLeft.fork();
            taskRight.fork();
            sum = taskLeft.join() + taskRight.join();
        }
        return sum;
    }

    public static void main(String[] args) {
        long[] data = new long[1024 * 1024];
        Arrays.setAll(data, i -> i);
        long sum = new ForkJoinPool().invoke(new ForkJoinDemoTask(data, 0, data.length - 1));

        System.out.println(sum);
    }
}
