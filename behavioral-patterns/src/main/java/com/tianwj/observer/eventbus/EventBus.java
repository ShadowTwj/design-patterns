package com.tianwj.observer.eventbus;

import com.google.common.util.concurrent.MoreExecutors;
import java.util.List;
import java.util.concurrent.Executor;

/**
 * 阻塞同步观察者模式
 *
 * @author tianwj
 */
public class EventBus {
    private final Executor executor;
    private final SubscriberRegistry registry = new SubscriberRegistry();

    public EventBus() {
        this(MoreExecutors.directExecutor());
    }

    public EventBus(Executor executor) {
        this.executor = executor;
    }

    public void register(Object object) {
        registry.register(object);
    }

    public void post(Object event) {
        List<Subscriber> subscribers = registry.getMatchedSubscribers(event);
        for (Subscriber subscriber : subscribers) {
            executor.execute(() -> subscriber.execute(event));
        }
    }
}
