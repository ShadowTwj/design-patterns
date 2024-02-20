package com.tianwj.bridge;

/**
 * @author tianwj
 * @date 2024/2/20 11:18
 */
public class Pentagon extends Shape {
    public Pentagon(Color color) {
        super(color);
    }

    @Override
    public void applyColor() {
        System.out.print("Pentagon filled with color ");
        color.applyColor();
    }
}
