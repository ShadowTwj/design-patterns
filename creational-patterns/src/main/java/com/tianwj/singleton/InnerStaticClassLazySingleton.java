package com.tianwj.singleton;

/**
 * 内部静态辅助类创建单例
 * <p>
 * 加载单例类时不会加载SingletonHelper类，只有调用getInstance方法时才会加载SingletonHelper类并创建单例类实例
 * 是单例使用最广泛的方法，因为不需要同步，并且很容易理解和实施，强列推荐使用
 *
 * @author tianwj
 */
public class InnerStaticClassLazySingleton {

    private InnerStaticClassLazySingleton() {
    }

    private static class SingletonHelper {
        private static final InnerStaticClassLazySingleton INSTANCE = new InnerStaticClassLazySingleton();
    }

    public static InnerStaticClassLazySingleton getInstance() {
        return SingletonHelper.INSTANCE;
    }
}
