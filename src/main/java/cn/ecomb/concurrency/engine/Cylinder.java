package cn.ecomb.concurrency.engine;

import cn.ecomb.concurrency.engine.logic.LogicHandler;

/**
 * @author zhouzhigang
 * @date 2018-12-26.
 */
public class Cylinder implements Runnable{

    private Resquest resquest;

    private LogicHandler head;

    public Cylinder() {
    }

    public Cylinder(Resquest resquest, LogicHandler head) {
        this.resquest = resquest;
        this.head = head;
    }

    @Override
    public void run() {
        head.handleRequest(resquest);
        System.out.println("气缸输出一点动能！！！");
        resquest.getResponse().setBody("完成功能");
    }
}
