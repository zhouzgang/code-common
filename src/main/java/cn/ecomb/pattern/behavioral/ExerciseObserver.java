package cn.ecomb.pattern.behavioral;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author zhouzhigang
 * @date 2017/11/13
 * 观察者模式，一对多状态通知
 * 数据双向绑定，MVVM
 */
public class ExerciseObserver {
    public static void main(String[] args) {
        ConcreteObserver observer1 = new ConcreteObserver();
        ConcreteObserver observer2 = new ConcreteObserver();
        ConcreteSubject subject = new ConcreteSubject();
        subject.registerObserver(observer1);
        subject.registerObserver(observer2);
        subject.setStatus(10);
        System.out.println("observer1--->" + observer1.getStatus() + ", observer2--->" + observer2.getStatus());
        subject.setStatus(18);
        System.out.println("observer1--->" + observer1.getStatus() + ", observer2--->" + observer2.getStatus());

    }
}


/**
 * 观察者接口
 */
interface Observer {
    void update(Subject subject);
}

/**
 * 主题接口
 */
interface Subject {
    List<Observer> observerList = new ArrayList<>();
    void registerObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObserver();
}

class ConcreteSubject implements Subject {

    private int status;

    @Override
    public void registerObserver(Observer observer) {
        ConcreteSubject.observerList.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        ConcreteSubject.observerList.remove(observer);
    }

    @Override
    public void notifyObserver() {
        for (Observer observer: ConcreteSubject.observerList) {
            observer.update(this);
        }
    }

    public void change() {
        this.notifyObserver();
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
        this.change();
    }
}

class ConcreteObserver implements Observer {

    private int status;

    @Override
    public void update(Subject subject) {
        this.setStatus(((ConcreteSubject) subject).getStatus());
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}






