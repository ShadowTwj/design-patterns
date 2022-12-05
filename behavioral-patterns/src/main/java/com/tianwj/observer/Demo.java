package com.tianwj.observer;

/**
 * 观察者Demo
 *
 * @author tianwj
 */
public class Demo {
    public static void main(String[] args) {
        ConcreteSubject subject = new ConcreteSubject();
        subject.registerObserver(new ConcreteObserverOne());
        subject.registerObserver(new ConcreteObserverTwo());
        subject.notifyObserver("message");
    }
}
