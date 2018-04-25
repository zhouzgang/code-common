package cn.ecomb.concurrency.producerconsumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedTransferQueue;


/**
 * @author zhouzhigang
 * @date 2018/4/17.
 */
public class MsgQueueManager<T> implements IBlockingQueue<T> {

    private static final Logger LOGGER = LoggerFactory.getLogger(MsgQueueManager.class);

    /**
     * 消息总队列
     */
    public final BlockingQueue<T> messageQueue;

    public MsgQueueManager() {
        this.messageQueue = new LinkedTransferQueue<>();
    }

    @Override
    public void put(T t) throws InterruptedException {
        messageQueue.put(t);
    }

    @Override
    public T take() throws InterruptedException {
        return messageQueue.take();
    }
}
