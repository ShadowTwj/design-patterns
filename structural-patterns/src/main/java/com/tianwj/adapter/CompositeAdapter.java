package com.tianwj.adapter;

/**
 * 组合实现适配器
 *
 * @author tianwj
 * @date 2024/2/19 17:09
 */
public class CompositeAdapter implements ITarget {
    private Adaptee adaptee;

    public CompositeAdapter(Adaptee adaptee) {
        this.adaptee = adaptee;
    }

    @Override
    public void f1() {
        adaptee.fa();
    }

    @Override
    public void f2() {
        adaptee.fb();
    }

    @Override
    public void f3() {
        adaptee.fc();
    }
}
