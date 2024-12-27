package com.zerofinance.camunda.services;

import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class MessageService implements JavaDelegate {
    @Autowired
    private RuntimeService runtimeService;

    @Override
    public void execute(DelegateExecution execution) throws Exception {
        log.info("发送消息");
        Object paymentMethod = execution.getVariable("paymentMethod");
        log.info("支付方式: {}", paymentMethod);
        runtimeService.correlateMessage("message_" + paymentMethod);
    }
}
