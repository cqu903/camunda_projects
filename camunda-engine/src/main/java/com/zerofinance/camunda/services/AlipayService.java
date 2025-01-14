package com.zerofinance.camunda.services;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class AlipayService implements JavaDelegate {

    @Override
    public void execute(DelegateExecution execution) throws Exception {
        log.info("支付宝支付");
        execution.setVariable("method", "alipay");
    }
}
