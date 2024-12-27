package com.zerofinance.camunda.tasks;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

public class ReserveRepairService implements JavaDelegate {

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        System.out.println("进入到预约家电修理任务");
        String currentActivityName = delegateExecution.getCurrentActivityName();
        String processDefinitionId = delegateExecution.getProcessDefinitionId();
        System.out.println("当前活动名称为：" + currentActivityName + ",当前定成定义id：" + processDefinitionId);
    }
}
