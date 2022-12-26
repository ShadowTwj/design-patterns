package com.tianwj.strategy;

import java.util.HashMap;
import java.util.Map;

/**
 * 策略工厂类
 * 维护指向具体策略的引用
 *
 * @author tianwj
 * @date 2022/12/26 11:40
 */
public class StrategyFactory {

    private static final Map<StrategyTypeEnum, Strategy> STRATEGY_MAP = new HashMap<>();

    static {
        STRATEGY_MAP.put(StrategyTypeEnum.A, new ConcreteStrategyA());
        STRATEGY_MAP.put(StrategyTypeEnum.B, new ConcreteStrategyB());
    }

    public static Strategy getStrategy(StrategyTypeEnum type) {
        return STRATEGY_MAP.get(type);
    }
}
