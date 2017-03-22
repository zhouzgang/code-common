package cn.ecomb.pattern.structure;

/**
 * Created by zhouzg on 2016/12/21.
 * <h3>装饰模式<h3/>
 * 动态地将责任附加到对象上。若要扩展功能，装饰者提供了比继承更有弹性的的替代方案
 * 总结：装饰模式的实现原理？？？ 思考代码区有问号的方法调用
 */
public class ExeciseDecorator {
    public void execute() {
        ICar car = new Car();
        SuperCar flyCar = new FlyCar(car);
        flyCar.run();       //？？？？？  他不能调用FlyCar的fly()方法，是因为继承的概念吗？
                            // 当一个类实现接口的时候是可以调用他自己的扩展方法的。
//        FlyCar flyCar1 = new FlyCar(car);
//        flyCar1.fly();
    }
}

//汽车的接口
interface ICar {
    void run();
}

//具体普通的汽车
class Car implements ICar {

    public void run() {
        System.out.println("普通汽车，在路上行驶");
    }
}

//超级汽车的父类
class SuperCar implements ICar {
    protected ICar car;

    public SuperCar(ICar car) {
        super();
        this.car = car;
    }

    public void run() {
        car.run();
    }
}

//会飞的超级汽车
class FlyCar extends SuperCar {

    public FlyCar(ICar car) {
        super(car);
    }
    public void fly() {
        System.out.println("超级汽车在飞");
    }
    public void run() {
        super.run();
        fly();
    }

}

//人工智能的超级汽车
class AiCar extends SuperCar {

    public AiCar(ICar car) {
        super(car);
    }
    public void auto() {
        System.out.println("超级汽车在自动驾驶");
    }
    public void run() {
        super.run();
        auto();
    }

}
