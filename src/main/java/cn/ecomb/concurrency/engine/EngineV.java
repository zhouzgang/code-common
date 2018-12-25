package cn.ecomb.concurrency.engine;

import cn.ecomb.concurrency.engine.logic.LogicHandler;

/**
 * @author zhouzhigang
 * @date 2018-12-26.
 */
public interface EngineV {

    LogicHandler init();

    void start();

    void run();

    void finish();

}
