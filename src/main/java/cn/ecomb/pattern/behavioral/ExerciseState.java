package cn.ecomb.pattern.behavioral;

/**
 * 状态模式
 * 执行每个状态的相关操作，并更新到下一个状态。
 * 持久化状态，找到当前的状态位置。
 * 更新状态时的数据一致性问题？
 * 对比 Spring StatusMachine
 *
 * @author zhouzhigang
 * @date 2017/11/25.
 */
public class ExerciseState {
    public static void execute() {
        State stateB = new Booked();
        Context context = new Context(stateB);
        context.setState(new Payed())
                .setState(new Sended())
                .setState(new InWay())
                .setState(new Recieved());
    }

    public static void main(String[] args) {
        execute();
    }
}

/**
 * 状态接口
 */
interface State {
    void handle();
}

class Booked implements State{
    @Override
    public void handle() {
        System.out.println("下单成功！");
    }
}

class Payed implements State {
    @Override
    public void handle() {
        System.out.println("支付成功！");
    }
}

class Sended implements State {
    @Override
    public void handle() {
        System.out.println("已发货！");
    }
}

class InWay implements State {
    @Override
    public void handle() {
        System.out.println("配送中。。。");
    }
}

class Recieved implements State {
    @Override
    public void handle() {
        System.out.println("已收货！");
    }
}

/**
 * 上下文
 */
class Context {
    private State state;

    Context(State state) {
        System.out.println("初始化状态。。。");
        this.state = state;
        state.handle();
    }

    Context setState(State state) {
        System.out.println("更新状态。。。");
        this.state = state;
        state.handle();
        return this;
    }
}