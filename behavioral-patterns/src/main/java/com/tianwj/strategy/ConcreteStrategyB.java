package com.tianwj.strategy;

/**
 * 具体策略实现类
 *
 * @author tianwj
 * @date 2022/12/26 11:39
 */
public class ConcreteStrategyB implements Strategy {
    @Override
    public void handle() {
        // ...
    }

    @Override
    public StrategyTypeEnum getType() {
        return StrategyTypeEnum.B;
    }
}
