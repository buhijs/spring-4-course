package com.realdolmen.spring.blog.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.webflow.config.AbstractFlowConfiguration;
import org.springframework.webflow.definition.registry.FlowDefinitionRegistry;
import org.springframework.webflow.engine.builder.support.FlowBuilderServices;
import org.springframework.webflow.executor.FlowExecutor;
import org.springframework.webflow.mvc.builder.MvcViewFactoryCreator;

import java.util.List;

@Configuration
public class WebFlowConfig extends AbstractFlowConfiguration {

    @Autowired
    private MvcConfig mvcConfig;

    @Autowired
    private List<ViewResolver> viewResolvers;

    @Autowired
    private Validator validator;

    @Bean
    public FlowExecutor flowExecutor() {
        return getFlowExecutorBuilder(flowRegistry())
                // .addFlowExecutionListener(new SecurityFlowExecutionListener(), "*")
                .build();
    }

    @Bean
    public FlowDefinitionRegistry flowRegistry() {
        return getFlowDefinitionRegistryBuilder(flowBuilderServices())
                .setBasePath("classpath*:/templates")
                .addFlowLocationPattern("/**/*-flow.xml")
                .build();
    }

    @Bean
    public FlowBuilderServices flowBuilderServices() {
        return getFlowBuilderServicesBuilder()
                .setViewFactoryCreator(mvcViewFactoryCreator())
                .setValidator(this.validator)
                .build();
    }

    @Bean
    public MvcViewFactoryCreator mvcViewFactoryCreator() {
        viewResolvers.add(this.mvcConfig.ajaxThymeleafViewResolver());

        MvcViewFactoryCreator factoryCreator = new MvcViewFactoryCreator();
        factoryCreator.setViewResolvers(viewResolvers);
        factoryCreator.setUseSpringBeanBinding(true);
        return factoryCreator;
    }

//    @Bean
//    public Validator validator() {
//        return new LocalValidatorFactoryBean();
//    }

}
