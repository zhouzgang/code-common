package cn.ecomb.concurrency.producerconsumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author zhouzhigang
 * @date 2018/4/17.
 */
public class ConditionBlockingQueue<T> implements IBlockingQueue {

    private static final Logger LOGGER = LoggerFactory.getLogger(ConditionBlockingQueue.class);

    private final Object[] items;
    int putptr, takeptr, count;

    private final Lock lock = new ReentrantLock();
    private final Condition notFull  = lock.newCondition();
    private final Condition notEmpty = lock.newCondition();


    public ConditionBlockingQueue(){
        this(10);
    }
    public ConditionBlockingQueue(int queueSize) {
        if(queueSize<1){
            throw new IllegalArgumentException("queueSize must be positive number");
        }
        items = new Object[queueSize];
    }

    @Override
    public void put(Object o) throws InterruptedException {
        lock.lock();
        while (count == items.length) {
            notFull.await();
        }
        items[putptr] = o;
        ++count;

    }

    @Override
    public Object take() throws InterruptedException {
        return null;
    }

}
