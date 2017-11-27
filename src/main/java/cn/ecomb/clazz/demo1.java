package cn.ecomb.clazz;

/**
 * 子类实例化时，父类的处理
 *
 * @author zhouzhigang
 * @date 2017/11/27.
 */
public class demo1 {
    public static void main(String[] args) {
        B b = new B();
    }
}

class A {
    private int varA1;
    public int var1;

    public A() {
        System.out.println("var1: " + this.var1);
    }
}

class B extends A {
    private int varA1;
    private int varB1;

    public B() {
        this.var1 = 2;
        System.out.println(this.var1);
        System.out.println();
    }
}