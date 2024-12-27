package com.zerofinance.camunda.tasks;

import java.util.concurrent.TimeUnit;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

@Component
public class Task1 implements JavaDelegate {

    @Override
    public void execute(DelegateExecution execution) throws Exception {
        System.out.println("Task1 is running");
        TimeUnit.SECONDS.sleep(5);
        System.out.println("Task1 is end");
    }
}
