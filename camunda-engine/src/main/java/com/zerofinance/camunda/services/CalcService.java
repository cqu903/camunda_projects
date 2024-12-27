package com.zerofinance.camunda.services;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

import cn.hutool.core.util.RandomUtil;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class CalcService implements JavaDelegate {

    @Override
    public void execute(DelegateExecution execution) throws Exception {
        int randomSeed = RandomUtil.randomInt(1, 100);
        log.info("开始执行任务" + randomSeed);
        Thread.sleep(5000);
        String task = (String) execution.getVariable("task");
        log.info("task:{}", task);
        log.info("任务执行完毕" + randomSeed);
    }
}
