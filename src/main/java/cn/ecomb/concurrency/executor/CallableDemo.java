package cn.ecomb.concurrency.executor;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author zhouzhigang
 * @date 2018/4/9.
 */
public class CallableDemo implements Callable {

    public static void main(String[] args) {
        FutureTask futureTask = new FutureTask(new CallableDemo());
        Thread thread = new Thread(futureTask);
        thread.start();
        try {
            Object object = futureTask.get();
            System.out.println(object);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Object call() throws Exception {
        return "Override call()";
    }
}
