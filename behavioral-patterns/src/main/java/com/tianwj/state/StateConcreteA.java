package com.tianwj.state;

/**
 * 具体状态
 *
 * @author tianwj
 * @date 2022/12/30 11:34
 */
public class StateConcreteA implements State {
    /**
     * 状态上下文，可以通过上下文引用获取所需信息
     * 并且通过上下文触发状态转移
     */
    private final StateContext context;

    public StateConcreteA(StateContext context) {
        this.context = context;
    }

    @Override
    public void eventAction() {
        // action...

        // 状态转移
        context.setState(new StateConcreteB(context));
    }
}
