package cn.ecomb.pattern.structure;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by zhouzg on 2016/12/22.
 * <h3>java 的动态代理</h3>
 * 使用java提供的接口生成代理对象，具体还需要了解生成代理的实际原理
 */
public class ExeciseDynamicProxy {
    public static void execute() {
        Star2 realStar2 = new RealStar2();
        Starhandler starhandler = new Starhandler(realStar2);
        Star2 proxy = (Star2) Proxy.newProxyInstance(ClassLoader.getSystemClassLoader(),
                new Class[]{Star2.class},
                starhandler);
        proxy.sing();
    }

    public static void main(String[] args) {
        execute();
    }
}

/**
 * 实际对象接口
 */
interface Star2 {
    void confer();
    void signContract();
    void sellTicket();
    void collectMoney();
    void sing();
}

/**
 * 实现类
 */
class RealStar2 implements Star2{

    @Override
    public void confer() {
        System.out.println("明星面谈");
    }

    @Override
    public void signContract() {
        System.out.println("明星签约");
    }

    @Override
    public void sellTicket() {
        System.out.println("明星售票");
    }

    @Override
    public void collectMoney() {
        System.out.println("明星收钱");
    }

    @Override
    public void sing() {
        System.out.println("明星唱歌");
    }
}

class Starhandler implements InvocationHandler {
    private Star2 realStar;
    public Starhandler(Star2 realStar) {
        super();
        this.realStar = realStar;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object obj = null;
        System.out.println("proxy代理签约");
        if (method.getName().equals("sing")) {
            obj = method.invoke(realStar, args);
        }
        System.out.println("proxy代理收钱");
        return obj;
    }
}
