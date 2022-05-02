package com.tianwj.singleton;

/**
 * 双重检查锁定单例
 * <p>
 * 延迟初始化、解决线程安全问题的同时，性能也较好，推荐使用
 *
 * @author tianwj
 */
public class DoubleCheckLazySingleton {
    private static volatile DoubleCheckLazySingleton instance;

    private DoubleCheckLazySingleton() {
    }

    public static DoubleCheckLazySingleton getInstance() {
        if (instance == null) {
            synchronized (DoubleCheckLazySingleton.class) {
                if (instance == null) {
                    instance = new DoubleCheckLazySingleton();
                }
            }
        }

        return instance;
    }
}
