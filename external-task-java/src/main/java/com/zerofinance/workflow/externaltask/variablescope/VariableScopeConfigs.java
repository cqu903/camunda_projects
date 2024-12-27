package com.zerofinance.workflow.externaltask.variablescope;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

import org.camunda.bpm.client.spring.annotation.ExternalTaskSubscription;
import org.camunda.bpm.client.task.ExternalTaskHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import cn.hutool.core.collection.ListUtil;
import cn.hutool.core.date.DateUtil;
import lombok.extern.slf4j.Slf4j;

@Configuration
@Slf4j
public class VariableScopeConfigs {

    @Bean
    @ExternalTaskSubscription(topicName = "upload_pics", processDefinitionKey = "Process_variable_scope")
    public ExternalTaskHandler uploadPicsSubscription() {
        return (externalTask, externalTaskService) -> {
            System.out.println("上传一批图片");
            List<Integer> pictureList = ListUtil.of(IntStream.range(0, 21).boxed().toArray(Integer[]::new));
            externalTaskService.complete(externalTask, Map.of("pictures", pictureList));
        };

    }

    @Bean
    @ExternalTaskSubscription(topicName = "add_pic_name", processDefinitionKey = "Process_variable_scope")
    public ExternalTaskHandler addPicNameSubscription() {
        return (externalTask, externalTaskService) -> {
            System.out.println("添加图片名称");
            Integer pictureId = externalTask.getVariable("picture");
            String picName = String.format("pic_%d.jpg", pictureId);
            log.info("为ID为{}的图片添加图片名称:{}", pictureId, picName);
            externalTaskService.complete(externalTask, null, Map.of("picName", picName));
        };
    }

    @Bean
    @ExternalTaskSubscription(topicName = "delete_water_mark", processDefinitionKey = "Process_variable_scope")
    public ExternalTaskHandler deleteWaterMarkSubscription() {
        return (externalTask, externalTaskService) -> {
            System.out.println("删除水印");
            String picName = externalTask.getVariable("picName");
            Integer picId = externalTask.getVariable("picture");
            String picDate = DateUtil.now();
            log.info("picId={},picName={},date={}",picId,picName,picDate);
            externalTaskService.complete(externalTask,null,Map.of("picDate",picDate));
        };
    }

    @Bean
    @ExternalTaskSubscription(topicName = "delete_pic_date", processDefinitionKey = "Process_variable_scope")
    public ExternalTaskHandler deletePicDateSubscription() {
        return (externalTask, externalTaskService) -> {
            System.out.println("删除图片日期");
            String picName = externalTask.getVariable("picName");
            Integer picId = externalTask.getVariable("picture");
            String picDate = externalTask.getVariable("picDate");
            String picIdUpperComplete = picId+"_upper_delete";
            log.info("picId={},picName={},picDate={},picIdUpperComplete={}",picId,picName,picDate,picIdUpperComplete);
            externalTaskService.complete(externalTask,null,Map.of("picIdUpperComplete",picIdUpperComplete));
        };
    }

    @Bean
    @ExternalTaskSubscription(topicName = "detect_face", processDefinitionKey = "Process_variable_scope")
    public ExternalTaskHandler detectFaceSubscription() {
        return (externalTask, externalTaskService) -> {
            System.out.println("检测人脸");
        };
    }

    @Bean
    @ExternalTaskSubscription(topicName = "detect_car", processDefinitionKey = "Process_variable_scope")
    public ExternalTaskHandler detectCarSubscription() {
        return (externalTask, externalTaskService) -> {
            System.out.println("检测汽车");
        };
    }

    @Bean
    @ExternalTaskSubscription(topicName = "upload_pic", processDefinitionKey = "Process_variable_scope")
    public ExternalTaskHandler uploadPicSubscription() {
        return (externalTask, externalTaskService) -> {
            System.out.println("上传图片");
        };
    }

    @Bean
    @ExternalTaskSubscription(topicName = "download_pics", processDefinitionKey = "Process_variable_scope")
    public ExternalTaskHandler downloadPicsSubscription() {
        return (externalTask, externalTaskService) -> {
            System.out.println("下载图片");
        };
    }

}
