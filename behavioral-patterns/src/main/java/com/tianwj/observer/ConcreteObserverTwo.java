package com.tianwj.observer;

/**
 * 观察者实现
 *
 * @author tianwj
 */
public class ConcreteObserverTwo implements Observer {
    @Override
    public void update(String message) {
        // add more
        System.out.println("ConcreteObserverTwo is notified");
    }
}
