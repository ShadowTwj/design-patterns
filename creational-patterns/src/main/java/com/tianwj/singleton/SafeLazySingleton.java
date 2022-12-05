package com.tianwj.singleton;

/**
 * 线程安全延迟初始化单例
 * <p>
 * 虽然解决了线程安全问题，但是因为使用同步方法，性能大大降低，所以不推荐使用
 *
 * @author tianwj
 */
public class SafeLazySingleton {
    private static SafeLazySingleton instance;

    private SafeLazySingleton() {
    }

    public static synchronized SafeLazySingleton getInstance() {
        if (instance == null) {
            instance = new SafeLazySingleton();
        }

        return instance;
    }
}