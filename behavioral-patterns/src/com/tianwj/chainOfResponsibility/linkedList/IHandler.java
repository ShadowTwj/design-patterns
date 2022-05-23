package com.tianwj.chainOfResponsibility.linkedList;

/**
 * 处理器通用接口
 * <p>
 * 链表实现
 *
 * @author tianwj
 */
public interface IHandler {

    /**
     * 设置下一个处理器
     *
     * @param nextHandler 下一个处理器
     */
    void setNextHandler(IHandler nextHandler);

    /**
     * 处理方法
     * <p>
     * 可以所有处理器都处理一遍，也可以提前终止，具体控制逻辑方法实现中处理
     */
    void handle();
}
