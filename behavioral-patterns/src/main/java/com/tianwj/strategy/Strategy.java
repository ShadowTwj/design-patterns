package com.tianwj.strategy;

/**
 * 策略定义：策略接口
 *
 * @author tianwj
 * @date 2022/12/26 11:34
 */
public interface Strategy {

    /**
     * 策略处理方法
     */
    void handle();

    /**
     * 获取策略类型枚举
     */
    StrategyTypeEnum getType();
}
