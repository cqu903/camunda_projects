package com.zerofinance.camunda.listeners;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.ExecutionListener;
import org.springframework.stereotype.Component;

@Component
public class CheckHomeAddress implements ExecutionListener {
    private final String DEFAULT_ADDRESS = "用户注册地址";

    @Override
    public void notify(DelegateExecution execution) throws Exception {
        System.out.println("NoticeCustomer");
        String homeAddress = (String) execution.getVariable("homeAddress");
        if (homeAddress == null) {
            System.out.println("用户未填写地址，使用默认地址");
            execution.setVariable("homeAddress", DEFAULT_ADDRESS);
        }
    }
}
