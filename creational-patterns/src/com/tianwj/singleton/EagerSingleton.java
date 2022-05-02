package com.tianwj.singleton;

/**
 * 饿汉式单例
 * 在类加载时创建，创建单例的最简单方式
 * <p>
 * 缺点：
 * 1.在使用之前创建实例，即使客户端不使用它也会创建
 * 2.不提供任何异常处理选项
 * <p>
 * 如果单例不使用大量资源，则直接使用这种方式最为简单，但如果单例是文件系统、数据库连接等资源，应该使用延迟加载
 *
 * @author tianwj
 */
public class EagerSingleton {

    private static final EagerSingleton INSTANCE = new EagerSingleton();

    private EagerSingleton() {
    }

    public static EagerSingleton getInstance() {
        return INSTANCE;
    }
}
