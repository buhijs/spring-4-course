package com.realdolmen.education;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.ws.client.core.WebServiceTemplate;

@Configuration
public class TestConfiguration {
    @Bean
    public WebServiceTemplate holidayServiceTemplate() {
        // TODO: return a configured WebServiceTemplate here. You can use the new Java config for this. Alternatively, you could also add a traditional <bean> configuration in webservice-context.xml
        return null;
    }
}
