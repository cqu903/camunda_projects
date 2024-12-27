package com.zerofinance.workflow.externaltask.spin;

import java.util.Arrays;

import org.camunda.bpm.client.spring.annotation.ExternalTaskSubscription;
import org.camunda.bpm.client.task.ExternalTask;
import org.camunda.bpm.client.task.ExternalTaskHandler;
import org.camunda.bpm.client.task.ExternalTaskService;
import org.camunda.bpm.engine.variable.VariableMap;
import org.camunda.bpm.engine.variable.Variables;
import org.camunda.spin.Spin;
import org.springframework.stereotype.Service;

import cn.hutool.core.date.DateUtil;
import cn.hutool.json.JSONUtil;
import lombok.extern.slf4j.Slf4j;

@Service
@ExternalTaskSubscription(topicName = "try_self_repair4", processDefinitionKey = "Process_external_spin", lockDuration = 10000)
@Slf4j
public class SelfRepairService4 implements ExternalTaskHandler {

    @Override
    public void execute(ExternalTask externalTask, ExternalTaskService externalTaskService) {
        System.out.println("外部任务进入尝试自己修理");
        ProductType productType = ProductType.builder().brand("小米").model("XIAOMI_ANDIJ_93739").power(100).build();
        CustomerMsg customerMsg = CustomerMsg.builder().name("xiaoming").product("烘干机").productAge(6)
                .purchaseDate(DateUtil.parseDate("2018-01-01")).productType(productType)
                .repairSites(Arrays.asList("北京", "上海", "广州")).build();
        String customerMsgStr = Spin.JSON(customerMsg).toString();
        log.info("customerMsgStr: {}", customerMsgStr);
        VariableMap variables = Variables.createVariables();
        variables.put("customerMsg", customerMsgStr);
        externalTaskService.complete(externalTask, variables);

    }

}