package com.zerofinance.camunda.services;

import java.util.concurrent.TimeUnit;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class FormatService implements JavaDelegate {

    @Override
    public void execute(DelegateExecution execution) throws Exception {
        log.info("进入格式化类");
        TimeUnit.SECONDS.sleep(10);
        log.info("格式化完成");
    }
}
