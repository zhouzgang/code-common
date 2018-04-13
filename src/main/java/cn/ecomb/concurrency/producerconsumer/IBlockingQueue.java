package cn.ecomb.concurrency.producerconsumer;

/**
 * @author zhouzhigang
 * @date 2018/4/11.
 */
public interface IBlockingQueue<T> {

    void put(T t) throws InterruptedException;

    T take() throws InterruptedException;

}
