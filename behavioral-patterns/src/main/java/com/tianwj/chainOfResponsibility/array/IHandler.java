package com.tianwj.chainOfResponsibility.array;

/**
 * 处理器通用接口
 * <p>
 * 数组实现
 *
 * @author tianwj
 */
public interface IHandler {

    /**
     * 处理方法1
     * <p>
     * 无返回值，所有处理器都处理一遍，不会中途终止
     */
    void handleAll();

    /**
     * 处理方法2
     * <p>
     * 根据返回值判断是否继续执行，可以提前终止
     *
     * @return 是否继续执行
     */
    boolean handleConditional();
}
