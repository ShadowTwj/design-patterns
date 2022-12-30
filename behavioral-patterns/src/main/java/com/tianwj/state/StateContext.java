package com.tianwj.state;

/**
 * 状态上下文
 * <p>
 * 保存了对于一个具体状态对象的引用， 并会将所有与该状态相关的工作委派给它
 * 上下文通过状态接口与状态对象交互， 且会提供一个设置器用于传递新的状态对象
 *
 * @author tianwj
 * @date 2022/12/30 11:31
 */
public class StateContext implements State {
    /**
     * 具体状态对象引用
     */
    private State state;

    public StateContext() {
        // 初始化状态
        this.state = new StateConcreteA(this);
    }

    @Override
    public void eventAction() {
        state.eventAction();
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }
}
