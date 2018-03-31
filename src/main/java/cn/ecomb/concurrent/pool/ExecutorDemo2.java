package cn.ecomb.concurrent.pool;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * @author zhouzhigang
 * @date 2018/2/27.
 */
public class ExecutorDemo2 {

    public static void main(String[] args) {
        ExecutorService es1 = Executors.newCachedThreadPool();
        List<Future<String>> list = new ArrayList<Future<String>>();

        for (int i = 0; i < 1000; i++) {
            list.add(es1.submit(new TestWithResult(i)));
        }

        for (Future<String> fl : list) {
            try {
                while (!fl.isDone());

                System.out.println("---->" + fl.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            } finally {
              es1.shutdown();
            }
        }
    }
}

class TestWithResult implements Callable<String> {

    private int i;

    public TestWithResult(int i) {
        this.i = i;
    }

    @Override
    public String call() throws Exception {
        System.out.println("执行--->:" + i + "--->" + Thread.currentThread().getName());
        return "执行--->:" + i + "--->" + Thread.currentThread().getName();
    }
}
