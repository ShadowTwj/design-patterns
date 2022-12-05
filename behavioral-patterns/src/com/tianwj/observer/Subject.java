package com.tianwj.observer;

/**
 * 被观察者接口
 * <p>
 * 与Publisher、Producer...等价
 *
 * @author tianwj
 */
public interface Subject {
    /**
     * 观察者注册方法
     *
     * @param observer 观察者对象
     */
    void registerObserver(Observer observer);

    /**
     * 观察者取消注册方法
     *
     * @param observer 观察者对象
     */
    void removeObserver(Observer observer);

    /**
     * 通知观察者接口
     * 可以使用线程池，达到异步非阻塞的效果
     *
     * @param message 通知消息
     */
    void notifyObserver(String message);
}
