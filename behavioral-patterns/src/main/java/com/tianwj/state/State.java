package com.tianwj.state;

/**
 * 通用状态接口，声明特定于状态的方法。
 *
 * @author tianwj
 * @date 2022/12/30 11:07
 */
public interface State {

    /**
     * 事件对应动作，并触发状态转移
     */
    void eventAction();
}
