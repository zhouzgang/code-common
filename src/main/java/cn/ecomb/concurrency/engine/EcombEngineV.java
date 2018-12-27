package cn.ecomb.concurrency.engine;

import cn.ecomb.concurrency.appdemo.Sum;
import cn.ecomb.concurrency.appdemo.Sum2;
import cn.ecomb.concurrency.engine.logic.*;

import java.util.LinkedList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author zhouzhigang
 * @date 2018/4/24.
 */
public class EcombEngineV{

    static LinkedList<Resquest> resquests = new LinkedList<Resquest>(){
        {
            add(new Resquest("R1"));
            add(new Resquest("R2"));
            add(new Resquest("R3"));
            add(new Resquest("R4"));
        }
    };

    static LogicHandler head = new HeadLogicHandler();


    public static LogicHandler init() {
        System.out.println("引擎初始化逻辑链路");
        LogicHandler signal = new SignalFilterLogicHandler();
        LogicHandler recognize = new RecognizeLogicHandler();
        LogicHandler appConfig = new AppConfigLogicHandler();
        LogicHandler recommendation = new RecommendationLogicHandler();
        head.setNextHandler(signal);
        signal.setNextHandler(recognize);
        recognize.setNextHandler(appConfig);
        appConfig.setNextHandler(recommendation);
        return head;
    }

    public static void start() {
        System.out.println("----Lamborghini Centenario 引擎启动----");
        int threadNum = resquests.size();
        ExecutorService executor = Executors.newFixedThreadPool(threadNum);

        for (int i = 0; i < threadNum; i++) {
            Resquest resquest = resquests.get(i);
            resquest.setResponse(new Response("Cylinder-" + i ));
            // 这里考虑使用另一线程池，避免不断的创建线程
            Thread thread = new Thread(new Cylinder(resquest, head));
            executor.execute(thread);
        }
        executor.shutdown();

        try {
            while (!executor.awaitTermination(10, TimeUnit.MILLISECONDS)){
                System.out.println("wait!");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < threadNum; i++) {
            System.out.println(resquests.get(i).getResponse().getUid() + ": " + resquests.get(i).getResponse().getBody());
        }

        System.out.println("引擎处理完毕～～～");
    }

    public void run() {

    }

    public void finish() {

    }

    public static void main(String[] args) {
        init();
        start();

//        int max = 10000;    // int 的范围
//        int sum = 0;
//        int threadNum = resquests.size();  // cup 核数

//        ExecutorService executor = Executors.newFixedThreadPool(threadNum);

//        ReSum[] subSum = new ReSum[threadNum];

//        long start = System.currentTimeMillis();
//        for (int i = 0; i < threadNum; i++) {
//            Resquest resquest = resquests.get(i);
//            resquest.setResponse(new Response("N_" + i ));
//            // 这里考虑使用另一线程池，避免不断的创建线程
//            Thread thread = new Thread(new Cylinder(resquest));
//            executor.execute(thread);
//        }
//        executor.shutdown();
//
//        try {
//            while (!executor.awaitTermination(10, TimeUnit.MILLISECONDS)){
//                System.out.printf("wait!");
//            }
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//
//        long end = System.currentTimeMillis();
//        System.out.println("子线程执行时长：" + (end - start));
//
//        for (int i = 0; i < threadNum; i++) {
//            System.out.println(resquests.get(i).getResponse().getUid() + ": " + resquests.get(i).getResponse().getBody());
//        }
//
//        System.out.println("返回结果……");
    }
    static class ReSum {
        int v;

        public ReSum(int v) {
            this.v = v;
        }
    }

}
