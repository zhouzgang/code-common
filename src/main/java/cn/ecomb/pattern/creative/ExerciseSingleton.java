package cn.ecomb.pattern.creative;

/**
 * Created by arron on 2016/12/19.
 * <h3>单例模式</h3>
 * 实践过程中返现有些自己还不会的基础知识点，如static, final的性质，线程安全，序列化
 * 这些都是要在下一步遍历《thinking in java》时要着重留意的
 * <li>饿汉式</li>
 * <li>懒汉式</li>
 * <li>双侧检验锁</li>
 * <li>静态内部类</li>
 * <li>枚举</li>
 */
public class ExerciseSingleton {
    //这里需要写一个线程来测试
    SingletonOne singletonOne = SingletonOne.getSingletonOne();
    SingletonTow singletonTow = SingletonTow.getSingletonTow();
    public void execute(){
        System.out.println(singletonOne.count);
        System.out.println(singletonTow.count);
    }
}

/**
 * 饿汉式，线程安全，效率高，不能延时加载
 * 对象一直没有使用，造成了资源浪费
 */
class SingletonOne {
    private static final SingletonOne singletonOne = new SingletonOne();
    public int count;
    private SingletonOne(){}
    public static SingletonOne getSingletonOne(){
        return singletonOne;
    }
}

class SingletonTow {
    private static SingletonTow singletonTow;
    public int count;
    private SingletonTow(){
        //防止反射破解，还不理解为什么呀？？？？？
        if(singletonTow != null)
            throw new RuntimeException();
    }
    public synchronized static SingletonTow getSingletonTow() {
        if(singletonTow == null)
            singletonTow = new SingletonTow();
        return singletonTow;

    }

    // 这一块还不知道为什么？？？？  等到看《thinking in java 》时回头来看一下这个点
    //防止反序列化破解
    /*
    private Object readResolve() {
        return instance;
    }
    */
    //防止反射破解
    /*
    private static Class getClass(String classname)
            throws ClassNotFoundException {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();

        if(classLoader == null)
            classLoader = SingletonTow.class.getClassLoader();

        return (classLoader.loadClass(classname));

    }
    */
}


/**
 * 静态内部类
 */
class SingletonThree {
    private static class inner {
        private static final SingletonThree instance = new SingletonThree();
    }
    private SingletonThree() {}
    public static final SingletonThree getInstance(){
        return inner.instance;
    }
}

/**
 * 枚举
 */
enum SingletonFour {
    INSTANCE;
    public void getInstance(){}
}
