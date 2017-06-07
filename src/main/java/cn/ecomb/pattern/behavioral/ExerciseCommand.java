package cn.ecomb.pattern.behavioral;


/**
 * 命令模式
 *
 * ## TODO
 * 需要找一个实际的应用实现场景，理解各类之间的关系
 *
 * Created by zhouzhigang on 2017/6/7.
 */
public class ExerciseCommand {

  public static void main(String[] args) {
    Command command = new ConcreteComman(new Receiver());
    Invoke invoker = new Invoke(command);
    invoker.call();
  }
}

/**
 * 命令接口
 */
interface Command {
  void execute();
}

/**
 * 命令实现类
 */
class ConcreteComman implements Command {

  // 为什么这个地方不用接口呢？
  private Receiver receiver;

  public ConcreteComman(Receiver receiver) {
    this.receiver = receiver;
  }

  @Override
  public void execute() {
    receiver.action();
  }
}

/**
 * 命令的请求者
 */
class Receiver {

  public void action() {
    System.out.println("执行命令");
  }

}

/**
 * 调用
 */
class Invoke {

  private Command command;

  public Invoke(Command command) {
    this.command = command;
  }

  public void call() {
    command.execute();
  }
}