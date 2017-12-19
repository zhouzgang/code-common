package cn.ecomb.concurrent;

/**
 * 双锁检测 单例模式
 * 相关参考网址： http://cloudate.net/?p=1228
 *
 * @author zhouzhigang
 * @date 2017/12/13.
 */
public class Demo2_DCL_Singleton {

    private volatile static Demo2_DCL_Singleton instance;

    private Demo2_DCL_Singleton() {
    }

    public static Demo2_DCL_Singleton getInstance() {
        if (instance == null) {
            synchronized (Demo2_DCL_Singleton.class) {
                if (instance == null) {
                    instance = new Demo2_DCL_Singleton();
                }
            }
        }
        return instance;
    }

    public static void main(String[] args) {
        Demo2_DCL_Singleton.getInstance();
    }
}
