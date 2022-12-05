package com.tianwj.chainOfResponsibility.linkedList;

/**
 * 职责链模式，处理器链
 * <p>
 * 链表实现
 *
 * @author tianwj
 */
public class HandlerChain {
    private IHandler head = null;
    private IHandler tail = null;

    /**
     * 添加处理器类
     * <p>
     * 也可以结合 Spring 的 ApplicationContextAware、InitializingBean 接口，获取所有处理器
     * <p>
     * public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
     * }
     * <p>
     * public void afterPropertiesSet() throws Exception {
     * handlers.addAll(applicationContext.getBeansOfType(IHandler.class).values());
     */
    public void addHandler(IHandler handler) {
        handler.setNextHandler(null);

        if (head == null) {
            head = handler;
            tail = handler;
            return;
        }

        tail.setNextHandler(handler);
        tail = handler;
    }

    public void handle() {
        if (head != null) {
            head.handle();
        }
    }
}
