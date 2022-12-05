package com.tianwj.observer.eventbus;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * 订阅者注册表
 *
 * @author tianwj
 */
public class SubscriberRegistry {
    private final ConcurrentMap<Class<?>, CopyOnWriteArraySet<Subscriber>> subscribers = new ConcurrentHashMap<>();

    public void register(Object listener) {
        Map<Class<?>, Collection<Subscriber>> listenerMethods = findAllSubscribers(listener);
        for (Map.Entry<Class<?>, Collection<Subscriber>> entry : listenerMethods.entrySet()) {
            Class<?> eventType = entry.getKey();
            Collection<Subscriber> eventMethodsInListener = entry.getValue();

            CopyOnWriteArraySet<Subscriber> eventSubscribers = subscribers.get(eventType);
            if (eventSubscribers == null) {
                subscribers.putIfAbsent(eventType, new CopyOnWriteArraySet<>());
                eventSubscribers = subscribers.get(eventType);
            }

            eventSubscribers.addAll(eventMethodsInListener);
        }
    }

    public void unregister(Object listener) {
        Map<Class<?>, Collection<Subscriber>> listenerMethods = findAllSubscribers(listener);

        for (Map.Entry<Class<?>, Collection<Subscriber>> entry : listenerMethods.entrySet()) {
            Class<?> eventType = entry.getKey();
            Collection<Subscriber> listenerMethodsForType = entry.getValue();

            CopyOnWriteArraySet<Subscriber> currentSubscribers = subscribers.get(eventType);
            if (currentSubscribers == null || !currentSubscribers.removeAll(listenerMethodsForType)) {
                throw new IllegalArgumentException("missing event subscriber for an annotated method. Is " + listener + " registered?");
            }
        }
    }

    private Map<Class<?>, Collection<Subscriber>> findAllSubscribers(Object listener) {
        Map<Class<?>, Collection<Subscriber>> eventTypeSubscribers = new HashMap<>();
        Class<?> clazz = listener.getClass();
        for (Method method : getAnnotatedMethods(clazz)) {
            Class<?>[] parameterTypes = method.getParameterTypes();
            Class<?> eventType = parameterTypes[0];
            eventTypeSubscribers.computeIfAbsent(eventType, k -> new ArrayList<>()).add(new Subscriber(listener, method));
        }

        return eventTypeSubscribers;
    }

    private List<Method> getAnnotatedMethods(Class<?> clazz) {
        List<Method> annotatedMethods = new ArrayList<>();
        for (Method method : clazz.getDeclaredMethods()) {
            if (method.isAnnotationPresent(Subscribe.class)) {
                // 校验注册方法参数
                Class<?>[] parameterTypes = method.getParameterTypes();
                if (parameterTypes.length != 1) {
                    throw new IllegalArgumentException(String.format(
                            "Method %s has @Subscribe annotation but has %s parameters. Subscriber methods must have exactly 1 parameter.",
                            method.getName(),
                            parameterTypes.length));
                }

                annotatedMethods.add(method);
            }
        }

        return annotatedMethods;
    }
}
