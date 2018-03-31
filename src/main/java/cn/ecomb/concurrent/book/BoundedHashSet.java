package cn.ecomb.concurrent.book;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Semaphore;

/**
 * 使用 Semaphore 为容器设置边界
 *
 * 理解：获取信号量中的虚拟许可（permit），释放虚拟许可
 *
 * @author zhouzhigang
 * @date 2018/1/15.
 */
public class BoundedHashSet<T> {
    private final Set<T> set;

    private final Semaphore sem;

    public BoundedHashSet(int bound) {
        this.set = Collections.synchronizedSet(new HashSet<>());
        this.sem = new Semaphore(bound);
    }

    public boolean add(T o) throws InterruptedException {
        sem.acquire();
        boolean wasAdded = false;
        try {
            wasAdded = set.add(o);
            return wasAdded;
        }finally {
            if (!wasAdded) {
                sem.release();
            }
        }
    }

    public boolean remove(Object o) {
        boolean wasRemoved = this.set.remove(o);
        if (wasRemoved) {
            sem.release();
        }
        return wasRemoved;
    }


    /**
     * 测试信号量
     * @param args
     */
    public static void main(String[] args) throws InterruptedException {
        BoundedHashSet<String> mySet = new BoundedHashSet<>(10);
        mySet.add("str1");
        mySet.add("str2");
        mySet.add("str3");
        mySet.remove("str2");

    }

}
