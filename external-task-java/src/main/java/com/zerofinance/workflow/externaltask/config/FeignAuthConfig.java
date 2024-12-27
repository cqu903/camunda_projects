package com.zerofinance.workflow.externaltask.config;

import org.camunda.bpm.client.spring.boot.starter.ClientProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import feign.auth.BasicAuthRequestInterceptor;

@Configuration
public class FeignAuthConfig {

    @Autowired
    private ClientProperties clientProperties;

    @Bean
    public BasicAuthRequestInterceptor basicAuthRequestInterceptor() {
        return new BasicAuthRequestInterceptor(clientProperties.getBasicAuth().getUsername(),
                clientProperties.getBasicAuth().getPassword());
    }

}
