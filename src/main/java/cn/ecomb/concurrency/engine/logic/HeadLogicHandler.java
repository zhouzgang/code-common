package cn.ecomb.concurrency.engine.logic;

import cn.ecomb.concurrency.engine.Resquest;

import java.util.Objects;

/**
 * @author zhouzhigang
 * @date 2018-12-26.
 */
public class HeadLogicHandler extends LogicHandler {

    @Override
    public void handleRequest(Resquest resquest) {
        System.out.println(Thread.currentThread().getName() + " 逻辑链头部开启");
        if (Objects.nonNull(nextHandler)) {
            nextHandler.handleRequest(resquest);
        }
    }

}
