package com.tianwj.strategy;

/**
 * 策略客户端，调用方
 *
 * @author tianwj
 * @date 2022/12/26 12:39
 */
public class StrategyClient {

    public static void main(String[] args) {
        // 一般根据运行时动态确定使用那种策略
        Strategy strategy = StrategyFactory.getStrategy(StrategyTypeEnum.A);
        strategy.handle();
    }
}
