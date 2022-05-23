package com.tianwj.chainOfResponsibility.linkedList;

/**
 * 具体处理器B
 * <p>
 * 链表实现
 *
 * @author tianwj
 */
public class ConcreteHandlerB extends BaseHandler {

    @Override
    public void handle() {
        boolean handled = false;
        // ...

        // 执行下个处理器，可以提前终止不执行
        if (!handled && handler != null) {
            handler.handle();
        }
    }
}
