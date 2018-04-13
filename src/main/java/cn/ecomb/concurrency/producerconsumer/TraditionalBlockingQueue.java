package cn.ecomb.concurrency.producerconsumer;

import java.util.LinkedList;
import java.util.List;

/**
 * @author zhouzhigang
 * @date 2018/4/11.
 */
public class TraditionalBlockingQueue<T> implements IBlockingQueue<T> {

    private int queueSize;
    private final List<T> queue = new LinkedList<>();
    private Object lock = new Object();
    private static final int DEFAULT_QUEUE_SIZE = 10;

    public TraditionalBlockingQueue() {
        this(DEFAULT_QUEUE_SIZE);
    }

    public TraditionalBlockingQueue(int queueSize) {
        if (queueSize < 1) {
            throw new IllegalArgumentException("队列大小必须为正数");
        }
        this.queueSize = queueSize;
    }

    @Override
    public void put(T t) throws InterruptedException {

    }

    @Override
    public T take() throws InterruptedException {
        return null;
    }
}
