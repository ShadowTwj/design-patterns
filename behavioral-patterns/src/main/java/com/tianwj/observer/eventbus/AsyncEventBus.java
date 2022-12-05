package com.tianwj.observer.eventbus;

import java.util.concurrent.Executor;

/**
 * 异步非阻塞观察者模式
 *
 * @author tianwj
 */
public class AsyncEventBus extends EventBus {
    public AsyncEventBus(Executor executor) {
        super(executor);
    }
}
