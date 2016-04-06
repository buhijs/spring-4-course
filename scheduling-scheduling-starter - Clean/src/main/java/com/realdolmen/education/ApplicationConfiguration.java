package com.realdolmen.education;

import org.springframework.context.annotation.*;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;

@Configuration
// TODO: enable async
// TODO: enable scheduling
@ComponentScan(basePackages = "com.realdolmen")
public class ApplicationConfiguration {
    // TODO: configure a TaskScheduler with a thread pool of 20. This can be done in here or in the XML file (context.xml)
}
