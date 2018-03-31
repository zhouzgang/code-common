package cn.ecomb.clazz;

/**
 * @author zhouzhigang
 * @date 2018/2/27.
 */
public class Demo6 {

    public static void main(String[] args) {
        BQ bq = new BQ();
        BQ.test(1);
    }
}

class AQ {
    public static void test() {
        System.out.println("---");
    }
}

class BQ extends AQ{
    public static void test(int i) {
        System.out.println("+++" + i);
    }
}
