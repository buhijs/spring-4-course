package com.realdolmen.education;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;

@Configuration
// TODO: enable async
@EnableAsync
// TODO: enable scheduling
@EnableScheduling
@ComponentScan(basePackages = "com.realdolmen")
public class ApplicationConfiguration {

    // TODO: configure a TaskScheduler with a thread pool of 20. This can be done in here or in the XML file (context.xml)
    @Bean
    public TaskScheduler taskScheduler() {
        ThreadPoolTaskScheduler scheduler = new ThreadPoolTaskScheduler();
        scheduler.setPoolSize(20);
        return scheduler;
    }

}
