package com.tianwj.template;

/**
 * 抽象类，定义算法骨架，以及需要重写的方法步骤
 *
 * @author tianwj
 * @date 2022/12/21 17:19
 */
public abstract class AbstractClass {
    public final void templateMethod() {
        method1();

        method2();
    }

    protected abstract void method1();

    protected abstract void method2();
}
