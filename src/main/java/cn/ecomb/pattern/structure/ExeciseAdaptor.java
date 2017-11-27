package cn.ecomb.pattern.structure;

/**
 * Created by arron on 2016/12/21.
 * 适配器模式
 * 适配器模式将一个类的接口，转换成客户期望的另一个接口。
 * 总结：适配器类实现目标接口的相关方法，
 *      实现方法里面使用需要被适配类的方法，
 *      调用目标接口。
 *      定义了适配的这么一个概念，平常在扩展一些接口的实现时也可以这么干吗？比如说打印日志？？
 *      代理模式又该怎么理解呢？
 */
public class ExeciseAdaptor {

    public void linkReq(Target target){
        target.handleReq();
    }

    public void execute() {
        Target adapter = new Adapter(new Adaptee());
        linkReq(adapter);
    }
}

/**
 * 需要被适配的类
 */
class Adaptee {
    public void request() {
        System.out.println("满足了客户端需求");
    }
}

/**
 * 目标类
 */
interface Target {
    void handleReq();
}

class Adapter implements Target {

    private Adaptee adaptee;

    public Adapter(Adaptee adaptee) {
        this.adaptee = adaptee;
    }

    @Override
    public void handleReq() {
        adaptee.request();
    }
}