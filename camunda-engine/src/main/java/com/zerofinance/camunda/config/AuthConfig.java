package com.zerofinance.camunda.config;

import org.camunda.bpm.engine.rest.security.auth.ProcessEngineAuthenticationFilter;
import org.camunda.bpm.engine.rest.security.auth.impl.HttpBasicAuthenticationProvider;
import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.context.annotation.Configuration;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.FilterRegistration.Dynamic;

@Configuration
public class AuthConfig implements ServletContextInitializer {

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        Dynamic filter = servletContext.addFilter("camunda-auth", ProcessEngineAuthenticationFilter.class);
        filter.setAsyncSupported(true);
        filter.setInitParameter("authentication-provider",
                "org.camunda.bpm.engine.rest.security.auth.impl.HttpBasicAuthenticationProvider");
        filter.addMappingForUrlPatterns(null, true, "/engine-rest/*");
    }
}
