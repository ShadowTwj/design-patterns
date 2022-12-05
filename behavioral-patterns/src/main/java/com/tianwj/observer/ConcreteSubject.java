package com.tianwj.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * 被观察者实现
 *
 * @author tianwj
 */
public class ConcreteSubject implements Subject {
    private final List<Observer> observerList = new ArrayList<>();

    private final Object MUTEX = new Object();

    @Override
    public void registerObserver(Observer observer) {
        if (observer == null) {
            throw new NullPointerException("registerObserver observer is null");
        }
        synchronized (MUTEX) {
            if (!observerList.contains(observer)) {
                observerList.add(observer);
            }
        }
    }

    @Override
    public void removeObserver(Observer observer) {
        if (observer == null) {
            throw new NullPointerException("removeObserver observer is null");
        }
        synchronized (MUTEX) {
            observerList.remove(observer);
        }
    }

    @Override
    public void notifyObserver(String message) {
        List<Observer> observerLocal;
        synchronized (MUTEX) {
            observerLocal = new ArrayList<>(this.observerList);
        }
        for (Observer observer : observerLocal) {
            observer.update(message);
        }
    }
}
