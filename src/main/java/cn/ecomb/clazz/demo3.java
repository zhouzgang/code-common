package cn.ecomb.clazz;

/**
 * @author zhouzhigang
 * @date 2017/12/6.
 */
public class demo3 {
    public static void main(String[] args) {
//        run1();
//        run2();
        run3();
    }

    /**
     * 使用子类调用父类的静态字段，不会导致子类初始化
     */
    public static void run1() {
        System.out.println(SubClass.value);
    }

    /**
     * 构建数组，不会导致类初始化
     */
    public static void run2() {
        SubClass[] var = new SubClass[10];
    }
    /**
     * 使用静态常量，不会导致类初始化
     */
    public static void run3() {
        System.out.println(SubClass.HELLO);
    }
}


class SuperClass {

    public static int value = 123;

    static {
        System.out.println("SuperClass init");
    }
}

class SubClass extends SuperClass {

    public static final String HELLO = "HELLO";

    static {
        System.out.println("SubClass init");
    }
}