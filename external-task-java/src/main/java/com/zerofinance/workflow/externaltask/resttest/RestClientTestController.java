package com.zerofinance.workflow.externaltask.resttest;

import java.util.List;

import org.camunda.bpm.engine.HistoryService;
import org.camunda.bpm.engine.RepositoryService;
import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.repository.Deployment;
import org.camunda.bpm.engine.repository.ProcessDefinition;
import org.camunda.bpm.engine.runtime.ProcessInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class RestClientTestController {

    @Autowired
    @Qualifier("remote")
    private RuntimeService runtimeService;
    @Autowired
    @Qualifier("remote")
    private RepositoryService repositoryService;
    @Autowired
    @Qualifier("remote")
    private HistoryService historyService;

    @GetMapping("/test")
    public void test() {
        List<ProcessDefinition> definitions = this.repositoryService.createProcessDefinitionQuery()
                .deploymentId("0fe42536-c019-11ef-bd40-de2f9da7dfbb").list();
        definitions.forEach(definition -> {
            log.info("processDefinitionId:{}", definition.getId());
            log.info("processDefinitionKey:{}", definition.getKey());
            log.info("processDefinitionVersion:{}", definition.getVersion());
        });
        List<Deployment> deployments = this.repositoryService.createDeploymentQuery()
                .deploymentId("0fe42536-c019-11ef-bd40-de2f9da7dfbb").list();
        deployments.forEach(deployment -> {
            log.info("deploymentId:{}", deployment.getId());
            log.info("deploymentName:{}", deployment.getName());
        });
        List<ProcessInstance> processInstances = this.runtimeService.createProcessInstanceQuery()
                .deploymentId("0fe42536-c019-11ef-bd40-de2f9da7dfbb").list();
        processInstances.forEach(processInstance -> {
            log.info("processInstanceId:{}", processInstance.getId());
            log.info("processInstanceBusinessKey:{}", processInstance.getBusinessKey());
        });

    }

}
