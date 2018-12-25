package cn.ecomb.concurrency.engine.logic;

import cn.ecomb.concurrency.engine.Resquest;

/**
 * @author zhouzhigang
 * @date 2018-12-26.
 */
public abstract class LogicHandler {

    protected LogicHandler nextHandler;

    public abstract void handleRequest(Resquest resquest);

    public LogicHandler getNextHandler() {
        return nextHandler;
    }

    public void setNextHandler(LogicHandler nextHandler) {
        this.nextHandler = nextHandler;
    }
}
