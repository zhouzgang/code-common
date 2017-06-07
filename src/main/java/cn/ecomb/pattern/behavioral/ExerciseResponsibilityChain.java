package cn.ecomb.pattern.behavioral;

/**
 * 责任链
 *
 * Created by zhouzhigang on 2017/6/8.
 */
public class ExerciseResponsibilityChain {

  public static void main(String[] args) {

    Handler handler1 = new ConcreteHandler1();
    Handler handler2 = new ConcreteHandler2();
    Handler handler3 = new ConcreteHandler3();

    //配置责任链
    handler1.setNextHandler(handler2);
    handler2.setNextHandler(handler3);

    //发请求
    handler1.handleRequest(1);
    handler1.handleRequest(2);
    handler1.handleRequest(3);
  }

}


/**
 *
 */
abstract class Handler {

  private Handler nextHandler;

  public abstract void handleRequest(int req);

  public Handler getNextHandler() {
    return nextHandler;
  }

  public void setNextHandler(Handler nextHandler) {
    this.nextHandler = nextHandler;
  }
}

class ConcreteHandler1 extends Handler {

  @Override
  public void handleRequest(int req) {
    if (req == 1)
      System.out.println("1处理");
    else {
      System.out.println("1释放请求");
      this.getNextHandler().handleRequest(req);
    }
  }
}

class ConcreteHandler2 extends Handler {

  @Override
  public void handleRequest(int req) {
    if (req == 2)
      System.out.println("2处理");
    else {
      System.out.println("2释放请求");
      this.getNextHandler().handleRequest(req);
    }
  }
}


class ConcreteHandler3 extends Handler {

  @Override
  public void handleRequest(int req) {
    if (req == 3)
      System.out.println("3处理");
    else {
      System.out.println("3释放请求");
      this.getNextHandler().handleRequest(req);
    }
  }
}