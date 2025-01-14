package com.zerofinance.camunda.services;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.springframework.stereotype.Service;

@Service("telCall")
public class TelCallService {

    public int doCall(DelegateExecution execution) {
        System.out.println("开始电话回访");
        String repairManName = String.valueOf(execution.getVariable("repairManName"));
        System.out.println("您对" + repairManName + "的服务打几分");
        execution.getActivityInstanceId();
        return 10;
    }

    public void getScore(DelegateExecution execution) {
        System.out.println("查看评分");
        String repairManName = String.valueOf(execution.getVariable("repairManName"));
        int score = (int) execution.getVariable("score");
        System.out.println("顾客对" + repairManName + "的评分为:" + score);
    }
}
