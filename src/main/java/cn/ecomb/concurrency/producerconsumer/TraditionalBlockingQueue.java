package cn.ecomb.concurrency.producerconsumer;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author zhouzhigang
 * @date 2018/4/11.
 */
public class TraditionalBlockingQueue<T> implements IBlockingQueue<T> {

    private int queueSize;
    private final LinkedList<T> queue = new LinkedList<>();
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
        synchronized (lock) {
            while (queue.size() >= queueSize) {
                lock.wait();
            }
            System.out.println("--put--");
            queue.add(t);
            lock.notifyAll();
        }
    }

    @Override
    public T take() throws InterruptedException {
        synchronized (lock) {
            while (queue.size() <= 0) {
                lock.wait();
            }
            System.out.println("--take--");
            T t = queue.removeFirst();
            lock.notifyAll();
            return t;
        }
    }
}







