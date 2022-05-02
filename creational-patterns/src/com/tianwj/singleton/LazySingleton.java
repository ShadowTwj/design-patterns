package com.tianwj.singleton;

/**
 * 延迟初始化单例
 * <p>
 * 优点：只有在使用时才会初始化
 * 缺点：不是线程安全的，在多线程环境下不可用
 *
 * @author tianwj
 */
public class LazySingleton {
    private static LazySingleton instance;

    private LazySingleton() {
    }

    public static LazySingleton getInstance() {
        if (instance == null) {
            instance = new LazySingleton();
        }

        return instance;
    }
}
