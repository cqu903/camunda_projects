package com.zerofinance.camunda.api;

import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.camunda.bpm.engine.IdentityService;
import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.runtime.ProcessInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/api")
public class CamundaController {
    @Autowired
    private IdentityService identityService;
    @Autowired
    private RuntimeService runtimeService;

    @GetMapping("/start/{processKey}")
    public String startProcess(@PathVariable("processKey") String processKey) {
        Map<String, Object> variables = new HashMap<>();
        variables.put("isFree", false);
        ProcessInstance processInstance = runtimeService.startProcessInstanceByKey(processKey, variables);
        return processInstance.getId();
    }
    // @GetMapping("/start/{processKey}")
    // public String startProcess(@PathVariable("processKey") String processKey) {
    // // 多实例串行
    // identityService.setAuthenticatedUserId("xiaoming");
    // Map<String, Object> variables = new HashMap<>();
    // variables.put("leaders", Arrays.asList("wangbing", "zhangsan", "wangwu"));
    // ProcessInstance processInstance =
    // runtimeService.startProcessInstanceByKey(processKey, variables);
    // return processInstance.getId();
    // }
    // @GetMapping("/start/{processKey}")
    // public String startProcess(@PathVariable("processKey") String processKey) {
    // // 多实例并行
    // identityService.setAuthenticatedUserId("xiaoming");
    // Map<String, Object> variables = new HashMap<>();
    // variables.put("leaders", Arrays.asList("wangbing", "zhangsan", "wangwu"));
    // ProcessInstance processInstance =
    // runtimeService.startProcessInstanceByKey(processKey, variables);
    // return processInstance.getId();
    // }
    // @GetMapping("/start/{processKey}")
    // public String startProcess(@PathVariable("processKey") String processKey) {
    // // 多实例并行--服务器任务
    // Map<String, Object> variables = new HashMap<>();
    // variables.put("tasks", Arrays.asList("xb01", "xb02", "xb03"));
    // ProcessInstance processInstance =
    // runtimeService.startProcessInstanceByKey(processKey, variables);
    // return processInstance.getId();
    // }

    // @GetMapping("/start/{processKey}")
    // public String startProcess(@PathVariable("processKey") String processKey) {
    // // 排他网关
    // identityService.setAuthenticatedUserId("xiaoming");
    // ProcessInstance processInstance =
    // runtimeService.startProcessInstanceByKey(processKey);
    // return processInstance.getId();
    // }

}
