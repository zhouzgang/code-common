package cn.ecomb.pattern.behavioral;

/**
 * Created by zhouzg on 2016/12/17.
 * <h3>策略模式，自己的理解：</h3>
 * <li>1. 面向接口编程</li>
 * <li>2. 通过上下文类接收不同的策略实现类，从而实现不同的执行策略，分装了执行的差异性</li>
 * <h3>HeadFirst中策略模式的定义：</h3>
 * <p>策略模式定义了算法族，分别封装起来，让它们之间可以相互替换，<br/>
 *     此模式让算法的变化独立于使用算法的客户。</p>
 */
public class ExerciseStrategy{
    public void run(){
        Strategy strategyA = new StrategyA();
        Centext centexta = new Centext(strategyA);
        centexta.execute();

        Strategy strategyB = new StrategyB();
        Centext centextb = new Centext(strategyB);
        centextb.execute();
    }
}

/**
 * 上下文类
 */
class Centext{
    Strategy strategy;

    public Centext(Strategy strategy) {
        this.strategy = strategy;
    }

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    public void execute(){
        this.strategy.action();
    }

}

/**
 * 策略接口
 */
interface Strategy{
    void action();
}

/**
 * 策略实现类A
 */
class StrategyA implements Strategy{
    public void action(){
        System.out.println("执行StrategyA中的action");
    }
}

/**
 * 策略实现类B
 */
class StrategyB implements Strategy{
    public void action(){
        System.out.println("执行StrategyB中的action");
    }
}
