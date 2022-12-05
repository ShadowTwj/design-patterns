package com.tianwj.chainOfResponsibility.array;

import java.util.ArrayList;
import java.util.List;

/**
 * 职责链模式，处理器链
 * <p>
 * 数组实现
 *
 * @author tianwj
 */
public class HandlerChain {
    private final List<IHandler> handlers = new ArrayList<>();

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
     * }
     */
    public void addHandler(IHandler handler) {
        this.handlers.add(handler);
    }

    /**
     * 处理方法1，所有处理器处理一遍
     */
    public void handleAll() {
        for (IHandler handler : handlers) {
            handler.handleAll();
        }
    }

    /**
     * 处理方法2，根据返回值判断是否继续执行
     */
    public void handleConditional() {
        for (IHandler handler : handlers) {
            boolean handled = handler.handleConditional();
            if (handled) {
                break;
            }
        }
    }
}
