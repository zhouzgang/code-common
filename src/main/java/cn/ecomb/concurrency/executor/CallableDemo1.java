package cn.ecomb.concurrency.executor;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author zhouzhigang
 * @date 2018/4/9.
 */
public class CallableDemo1 implements Callable {

    private AtomicInteger atomicInteger = new AtomicInteger(0);

    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        method1();
//        method2();
//        method3();
        method4();
    }

    private static void method4() throws InterruptedException, ExecutionException {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        CompletionService<Integer> completionService = new ExecutorCompletionService<>(executorService);
        CallableDemo1 demo1 = new CallableDemo1();
        for (int i = 0; i < 50; i++) {
            completionService.submit(demo1);
        }
        for (int i = 0; i < 50; i++) {
            System.out.println(completionService.take().get());
        }
        executorService.shutdown();
    }

    private static void method3() throws InterruptedException, ExecutionException {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        List<Callable<CallableDemo1>> list = new ArrayList<>();
//        CallableDemo1 demo1 = new CallableDemo1();
//        for (int i = 0; i < 50; i++) {
//            list.add(demo1);
//        }
//        Object o = executorService.invokeAny(list);
//        System.out.println(o);

        CallableDemo1 demo2 = new CallableDemo1();
        for (int i = 0; i < 50; i++) {
            list.add(demo2);
        }
        List<Future<CallableDemo1>> futures = executorService.invokeAll(list);
        for (int i = 0; i < 5; i++) {
            System.out.println( futures.get(i).get());
        }
        executorService.shutdown();

    }

    private static void method2() throws InterruptedException, ExecutionException {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future future = executorService.submit(new CallableDemo1());
        executorService.shutdown();
        System.out.println(future.get());
    }

    private static void method1() throws InterruptedException, ExecutionException {
        FutureTask futureTask = new FutureTask(new CallableDemo1());
        Thread thread = new Thread(futureTask);
        thread.start();
        if (futureTask.isDone()) {
            futureTask.cancel(true);
        }
        System.out.println(futureTask.get());
    }

    @Override
    public Object call() throws Exception {
        synchronized (this) {
            for (int i = 0; i < 100; i++) {
                atomicInteger.set(atomicInteger.get() + 1);
            }
//            TimeUnit.MICROSECONDS.sleep(10);
        }
        return atomicInteger.get();
    }
}
