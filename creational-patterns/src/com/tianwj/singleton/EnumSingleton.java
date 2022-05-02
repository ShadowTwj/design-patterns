package com.tianwj.singleton;

/**
 * 枚举单例
 * <p>
 * 正常单例实现方法，反射都可以破坏单例模式
 * 可以使用Enum来实现单例，因为Java保证任何枚举值都会只实例化一次
 * <p>
 * 缺点：不允许延迟初始化
 *
 * @author tianwj
 */
public enum EnumSingleton {
    /**
     * instance
     */
    INSTANCE;

    public static void doSomething() {
        // do something
    }
}
