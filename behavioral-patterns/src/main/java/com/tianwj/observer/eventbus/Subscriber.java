package com.tianwj.observer.eventbus;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 用来表示{@link Subscribe}注解的方法
 *
 * @author tianwj
 */
public class Subscriber {
    /**
     * 订阅者类
     */
    private final Object target;

    /**
     * 订阅者具体执行方法
     */
    private final Method method;

    public Subscriber(Object target, Method method) {
        this.target = target;
        this.method = method;
        this.method.setAccessible(true);
    }

    /**
     * 执行订阅者方法
     *
     * @param event method方法的参数
     */
    public void execute(Object event) {
        try {
            method.invoke(target, event);
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }
}
