package com.zerofinance.workflow.externaltask.spin;

import org.camunda.bpm.client.spring.annotation.ExternalTaskSubscription;
import org.camunda.bpm.client.task.ExternalTask;
import org.camunda.bpm.client.task.ExternalTaskHandler;
import org.camunda.bpm.client.task.ExternalTaskService;
import org.camunda.spin.Spin;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

/**
 * 邮寄维修
 */
@Service
@ExternalTaskSubscription(topicName = "post_repair", processDefinitionKey = "Process_external_spin", lockDuration = 10000)
@Slf4j
public class PostRepairService implements ExternalTaskHandler {

    @Override
    public void execute(ExternalTask externalTask, ExternalTaskService externalTaskService) {
        System.out.println("外部任务进入邮寄维修");
        String customerMsgStr = externalTask.getVariable("customerMsg");
        String product = Spin.JSON(customerMsgStr).prop("product").stringValue();

        log.info("客户产品信息: " + product);

        externalTaskService.complete(externalTask);
    }

}