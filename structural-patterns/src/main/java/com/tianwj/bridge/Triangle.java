package com.tianwj.bridge;

/**
 * @author tianwj
 * @date 2024/2/20 11:17
 */
public class Triangle extends Shape {

    public Triangle(Color color) {
        super(color);
    }

    @Override
    public void applyColor() {
        System.out.print("Triangle filled with color ");
        color.applyColor();
    }
}
