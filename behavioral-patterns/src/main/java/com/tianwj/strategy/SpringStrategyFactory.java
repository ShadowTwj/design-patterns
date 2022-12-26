package com.tianwj.strategy;

import java.util.EnumMap;
import java.util.Map;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * Spring实现策略工厂
 * 维护指向具体策略的引用
 *
 * @author tianwj
 * @date 2022/12/26 11:50
 */
@Component
public class SpringStrategyFactory implements ApplicationContextAware, InitializingBean {

    private ApplicationContext applicationContext;

    private static final Map<StrategyTypeEnum, Strategy> ENUM_MAP = new EnumMap<>(StrategyTypeEnum.class);

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        applicationContext.getBeansOfType(Strategy.class).values().forEach(strategy -> ENUM_MAP.put(strategy.getType(), strategy));
    }

    public Strategy getStrategy(StrategyTypeEnum typeEnum) {
        return ENUM_MAP.get(typeEnum);
    }
}
