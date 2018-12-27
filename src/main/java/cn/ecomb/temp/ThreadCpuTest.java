package cn.ecomb.temp;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * @author zhouzg
 * @date 2018/8/23
 */
public class ThreadCpuTest {
    public static void main(String[] args) {
        Thread busyTask = new Thread(() -> {
            for (;;) {
                double a = new Random().nextDouble();
                double b = new Random().nextDouble();

                double c = a * b;
            }
        });
        busyTask.setName("busy task");
        busyTask.start();

        Thread lazyTask = new Thread(() -> {
            for (;;) {
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        busyTask.setName("lazy task");
        lazyTask.start();
    }
}
