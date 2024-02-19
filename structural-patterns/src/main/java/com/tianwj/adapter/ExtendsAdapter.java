package com.tianwj.adapter;

/**
 * 继承实现适配器
 *
 * @author tianwj
 * @date 2024/2/19 17:06
 */
public class ExtendsAdapter extends Adaptee implements ITarget {

    @Override
    public void f1() {
        super.fa();
    }

    @Override
    public void f2() {
        super.fb();
    }

    @Override
    public void f3() {
        super.fc();
    }
}
