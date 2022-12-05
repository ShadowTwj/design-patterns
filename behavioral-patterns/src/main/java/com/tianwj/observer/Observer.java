package com.tianwj.observer;

/**
 * 观察者接口
 * <p>
 * 与Subscriber、Consumer...等价
 *
 * @author tianwj
 */
public interface Observer {
    void update(String message);
}
