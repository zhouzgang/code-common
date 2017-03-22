package cn.ecomb.pattern.structure;

/**
 * Created by zhouzg on 2016/12/22.
 * <h3>静态代理</h3>
 * 为另外一个对象提供一个代理对象以控制对这个对象的访问
 *
 */
public class ExeciseStaticProxy {
    public void execute() {
        Star realStar = new RealStar();
        Star proxyStar = new ProxyStar(realStar);
        proxyStar.confer();
        proxyStar.signContract();
        proxyStar.sellTicket();
        proxyStar.collectMoney();
        proxyStar.sing();
    }
}

//实际对象接口
interface Star {
    void confer();
    void signContract();
    void sellTicket();
    void collectMoney();
    void sing();
}

//实现类
class RealStar implements Star{

    public void confer() {
        System.out.println("明星面谈");
    }

    public void signContract() {
        System.out.println("明星签约");
    }

    public void sellTicket() {
        System.out.println("明星售票");
    }

    public void collectMoney() {
        System.out.println("明星收钱");
    }

    public void sing() {
        System.out.println("明星唱歌");
    }
}

class ProxyStar implements Star{

    private Star realStar ;

    public ProxyStar(Star realStar) {
        this.realStar = realStar;
    }

    public void confer() {
        System.out.println("代理面谈");
    }

    public void signContract() {
        System.out.println("代理签约");
    }

    public void sellTicket() {
        System.out.println("代理售票");
    }

    public void collectMoney() {
        System.out.println("代理收钱");
    }

    public void sing() {
        realStar.sing();
    }
}


