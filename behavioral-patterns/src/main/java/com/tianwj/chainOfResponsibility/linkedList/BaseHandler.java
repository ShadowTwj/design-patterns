package com.tianwj.chainOfResponsibility.linkedList;

/**
 * 基础处理器
 * <p>
 * 是一个可选类，可以将所有处理器共有的逻辑封装在一起
 *
 * @author tianwj
 */
public abstract class BaseHandler implements IHandler {
    protected IHandler handler = null;

    @Override
    public void setNextHandler(IHandler nextHandler) {
        this.handler = nextHandler;
    }
}
