package com.zerofinance.camunda.listeners;

import java.util.concurrent.TimeUnit;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.ExecutionListener;
import org.springframework.stereotype.Component;

@Component
public class NoticeCustomer implements ExecutionListener {

    @Override
    public void notify(DelegateExecution execution) throws Exception {
        System.out.println("进入客户通知监听器");
        String homeAddress = (String) execution.getVariable("homeAddress");
        System.out.println("homeAddress: " + homeAddress);
        TimeUnit.SECONDS.sleep(2);
        System.out.println(String.format("客户你好，师傅正在赶往%s为你修理家电", homeAddress));
    }
}
