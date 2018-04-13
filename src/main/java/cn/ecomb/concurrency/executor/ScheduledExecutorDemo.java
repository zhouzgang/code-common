package cn.ecomb.concurrency.executor;

import java.util.concurrent.*;

/**
 * @author zhouzhigang
 * @date 2018/4/9.
 */
public class ScheduledExecutorDemo implements Runnable{

    private String jobName;

    public ScheduledExecutorDemo(String jobName) {
        this.jobName = jobName;
    }

    @Override
    public void run() {
        System.out.println(jobName);
    }

    public static void main(String[] args) {
//        ThreadFactory factory = new Threa
//        ExecutorService executorService = new ThreadPoolExecutor()

        ScheduledExecutorService service = Executors.newScheduledThreadPool(10);
        long initialDelay1 = 1;
        long period1 = 1;
        // 从现在开始1秒钟之后，每隔1秒钟执行一次job1
        service.scheduleAtFixedRate(
                new ScheduledExecutorDemo("job" + period1), initialDelay1,
                period1, TimeUnit.SECONDS);

    }
}
