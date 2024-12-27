package com.zerofinance.camunda.services;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Service;

@Service("doRepair")
public class DoingRepairService implements JavaDelegate {
    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        System.out.println("开始上门修理");
        String currentActivityName = delegateExecution.getCurrentActivityName();
        System.out.println("当前活动名称为：" + currentActivityName);
        delegateExecution.setVariable("repairManName", "王晓曼");

    }
}
