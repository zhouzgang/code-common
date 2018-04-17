package cn.ecomb.concurrency.producerconsumer;

/**
 * @author zhouzhigang
 * @date 2018/4/11.
 *
 * 阻塞队列接口
 */
public interface IBlockingQueue<T> {

    void put(T t) throws InterruptedException;

    T take() throws InterruptedException;

}
