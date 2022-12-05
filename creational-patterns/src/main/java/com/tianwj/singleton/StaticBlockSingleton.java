package com.tianwj.singleton;

/**
 * 静态块初始化单例
 * <p>
 * 类似饿汉式，区别是实例在静态块中创建的，可以处理异常
 *
 * @author tianwj
 */
public class StaticBlockSingleton {
    private static StaticBlockSingleton instance;

    private StaticBlockSingleton() {
    }

    static {
        try {
            instance = new StaticBlockSingleton();
        } catch (Exception e) {
            throw new RuntimeException("create singleton instance error");
        }
    }

    public static StaticBlockSingleton getInstance() {
        return instance;
    }
}
