package cn.ecomb.pattern.aopProxySimpleDemo;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by zhouzhigang on 2017/10/24.
 */
public class demo1 {


}


interface IHello {
    void sayHello();
}

class Hello implements IHello {

    @Override
    public void sayHello() {
        System.out.println("hello!!!");
    }
}

interface ILogger {
    void start();
    void end();
}

class Logger implements ILogger {

    @Override
    public void start() {
        System.out.println("start Logger");
    }

    @Override
    public void end() {
        System.out.println("end Logger");
    }
}

class DynaProxyHello implements InvocationHandler {




    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return null;
    }
}










