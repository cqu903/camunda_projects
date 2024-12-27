package com.zerofinance.camunda.services;

import java.util.ArrayList;
import java.util.List;

import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class AddLeadersService implements JavaDelegate {

    @Override
    public void execute(DelegateExecution execution) throws Exception {
        long leaveDays = (Long) execution.getVariable("leaveDays");
        log.info("进入增加领导集合类，员工请假天数为: {}", leaveDays);
        List<String> leaders = new ArrayList<>();
        if (leaveDays > 3 && leaveDays <= 5) {
            leaders.add("wangbing");
            leaders.add("zhangsan");
        } else if (leaveDays > 5) {
            leaders.add("wangbing");
            leaders.add("zhangsan");
            leaders.add("wangwu");
        }
        execution.setVariable("leaders", leaders);
    }
}
