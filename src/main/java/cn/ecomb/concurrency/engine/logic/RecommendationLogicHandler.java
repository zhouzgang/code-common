package cn.ecomb.concurrency.engine.logic;

import cn.ecomb.concurrency.engine.Resquest;

import java.util.Objects;

/**
 * 推荐服务逻辑
 * @author zhouzhigang
 * @date 2018-12-26.
 */
public class RecommendationLogicHandler extends LogicHandler {

    @Override
    public void handleRequest(Resquest resquest) {
        System.out.println(Thread.currentThread().getName() + " 根据不同的场景推荐服务");
        if (Objects.nonNull(nextHandler)) {
            nextHandler.handleRequest(resquest);
        }

    }

}
