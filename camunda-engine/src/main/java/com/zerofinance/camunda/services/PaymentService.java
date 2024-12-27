package com.zerofinance.camunda.services;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class PaymentService implements JavaDelegate {

    @Override
    public void execute(DelegateExecution execution) throws Exception {
        String method = (String) execution.getVariable("method");
        log.info("支付成功, 支付方式: {}", method);
    }
}
