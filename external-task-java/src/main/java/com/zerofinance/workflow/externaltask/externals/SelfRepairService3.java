package com.zerofinance.workflow.externaltask.externals;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.camunda.bpm.client.spring.annotation.ExternalTaskSubscription;
import org.camunda.bpm.client.task.ExternalTask;
import org.camunda.bpm.client.task.ExternalTaskHandler;
import org.camunda.bpm.client.task.ExternalTaskService;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Service
// @ExternalTaskSubscription(topicName = "try_self_repair3",
// processDefinitionKey = "Process_external_task_with_listeners", lockDuration =
// 10000)
@Slf4j
public class SelfRepairService3 implements ExternalTaskHandler {

    @Override
    public void execute(ExternalTask externalTask, ExternalTaskService externalTaskService) {
        log.info(Thread.currentThread().getName());
        log.info("外部任务进入尝试自己修理");
        try {
            TimeUnit.SECONDS.sleep(15);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        boolean isFree = (boolean) externalTask.getVariable("isFree");
        if (isFree) {
            log.info("免费维修");
            // externalTaskService.complete(externalTask);
            externalTaskService.handleFailure(externalTask, "维修是免费的，我不想自己修理了", "这里可以打印异常堆栈", 0, 5000);
        } else {
            log.info("收费维修");
            externalTaskService.complete(externalTask);
        }
    }

}