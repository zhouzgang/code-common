package cn.ecomb.concurrency;

import org.junit.Test;

import java.util.ArrayList;
import java.util.concurrent.*;

/**
 * Created by arron on 2017/2/8.
 */
public class TestListOff {

    @Test
    public void testListOff(){
        LiftOff launch = new LiftOff();
        launch.run();
    }

    @Test
    public void testDriveThread(){
        Thread thread = new Thread(new LiftOff());
        thread.start();
        System.out.println("waiting for LiftOff");
    }


    public static void main(String args[]){
//        Thread t = new Thread(new LiftOff());
//        t.start();
//        Thread t1 = new Thread(new LiftOff());
//        t1.start();
//        System.out.println("waiting for LiffOff");

//        testExecutor();

//        CallableDemo();


    }

    private static void CallableDemo() {
        ExecutorService exec = Executors.newCachedThreadPool();
        ArrayList<Future<String>> results = new ArrayList<>();
        for (int i = 0; i < 5; i++)
            results.add(exec.submit(new TaskWithResult(i)));
        for (Future<String> result : results) {
            try{
                System.out.println(result.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
                return;
            } catch (ExecutionException e) {
                e.printStackTrace();
            }finally {
                 exec.shutdown();
            }
        }
    }

    private static void testExecutor() {
        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++)
            exec.execute(new LiftOff());
        exec.shutdown();
    }

}

class TaskWithResult implements Callable<String> {
    private int id;

    public TaskWithResult(int id) {
        this.id = id;
    }

    @Override
    public String call() throws Exception {
        return "return of TaskWithResult" + id;
    }
}
