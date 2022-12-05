package com.tianwj.observer;

/**
 * 观察者实现
 *
 * @author tianwj
 */
public class ConcreteObserverOne implements Observer {
    @Override
    public void update(String message) {
        // add more
        System.out.println("ConcreteObserverOne is notified");
    }
}
