package cn.ecomb.concurrency.engine.logic;

import cn.ecomb.concurrency.engine.Resquest;

import java.util.Objects;

/**
 * @author zhouzhigang
 * @date 2018-12-26.
 */
public class AppConfigLogicHandler extends LogicHandler {

    @Override
    public void handleRequest(Resquest resquest) {
        System.out.println(Thread.currentThread().getName() + " 根据不同的手机厂商配置场景");
        if (Objects.nonNull(nextHandler)) {
            nextHandler.handleRequest(resquest);
        }

    }

}
