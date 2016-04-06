package com.realdolmen.education;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ComponentScan("com.realdolmen.education")
@ImportResource("classpath:/webservice-context.xml")
public class WebConfiguration {
}
