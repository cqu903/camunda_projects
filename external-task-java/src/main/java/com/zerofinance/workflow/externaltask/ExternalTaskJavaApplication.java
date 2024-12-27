package com.zerofinance.workflow.externaltask;

import org.camunda.community.rest.EnableCamundaRestClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableCamundaRestClient
public class ExternalTaskJavaApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExternalTaskJavaApplication.class, args);
	}

}
