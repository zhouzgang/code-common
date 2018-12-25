package cn.ecomb.concurrency.engine.logic;

import cn.ecomb.concurrency.engine.Resquest;

import java.util.Objects;

/**
 * @author zhouzhigang
 * @date 2018-12-26.
 */
public class RecognizeLogicHandler extends LogicHandler {

    @Override
    public void handleRequest(Resquest resquest) {
        System.out.println(Thread.currentThread().getName() + " 识别出场景类型");
        if (Objects.nonNull(nextHandler)) {
            nextHandler.handleRequest(resquest);
        }
    }

}
