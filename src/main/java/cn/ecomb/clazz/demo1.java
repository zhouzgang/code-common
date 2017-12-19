package cn.ecomb.clazz;

/**
 * 子类实例化时，父类的处理
 *
 * @author zhouzhigang
 * @date 2017/11/27.
 */
public class demo1 {
    public static void main(String[] args) {
        A a = new A();
        B b = new B();
        C c = new C();
        System.out.println("a.var1---->" + A.var1);
        System.out.println("b.var1---->" + B.var1);
        System.out.println("c.var1---->" + C.var1);

//        System.out.println("a.t.vart---->" + a.t.vart);
//        System.out.println("b.t.vart---->" + b.t.vart);
//        System.out.println("c.t.vart---->" + c.t.vart);
    }
}

class T {
    public int vart;
}

class A {
    private int varA1;
    public static int var1;
    public T t = new T();

    public A() {
        var1 = 1;
        System.out.println("A():--->var1: " + var1);

//        t.vart = 9;
//        System.out.println("A():-->t.vart:--->vart: " + this.t.vart);
    }
}

class B extends A {
    private int varA1;
    private int varB1;

    public B() {
        System.out.println("B():before--->var1: " + var1);
        var1 = 2;
        System.out.println("B():after--->var1: " + var1);

//        System.out.println("B():before-->t.vart:--->vart: " + this.t.vart);
//        this.t.vart = 8;
//        System.out.println("B():after-->t.vart:--->vart: " + this.t.vart);
    }
}

class C extends A {
    private int varA1;
    private int varC1;

    public C() {
        System.out.println("C():before--->var1: " + var1 +"--C.var1-->"+ C.var1);
        var1 = 3;
        System.out.println("C():after--->var1: " + var1);

//        System.out.println("C():before-->t.vart:--->vart: " + this.t.vart);
//        this.t.vart = 7;
//        System.out.println("C():after--->t.vart:--->vart: " + this.t.vart);
    }
}