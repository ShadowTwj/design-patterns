package com.tianwj.bridge;

/**
 * 桥接模式，"抽象"类
 *
 * @author tianwj
 * @date 2024/2/20 11:15
 */
public abstract class Shape {
    protected Color color;

    public Shape(Color color) {
        this.color = color;
    }

    abstract public void applyColor();
}
