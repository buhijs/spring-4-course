package com.realdolmen.education;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.oxm.Marshaller;
import org.springframework.oxm.Unmarshaller;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.ws.client.core.WebServiceTemplate;

@Configuration
public class TestConfiguration {

    @Bean
    public WebServiceTemplate holidayServiceTemplate() {
        // TODO: return a configured WebServiceTemplate here. You can use the new Java config for this. Alternatively, you could also add a traditional <bean> configuration in webservice-context.xml
        WebServiceTemplate template = new WebServiceTemplate();
        template.setMarshaller(marshaller());
        template.setUnmarshaller(unMarshaller());
        template.setDefaultUri("http://localhost:8080/holidayService");
        return template;
    }

    @Bean
    public Unmarshaller unMarshaller() {
        Jaxb2Marshaller m = new Jaxb2Marshaller();
        m.setPackagesToScan(new String[] {"com.realdolmen.education.xml"});
        return m;
    }

    @Bean
    public Marshaller marshaller() {
        Jaxb2Marshaller m = new Jaxb2Marshaller();
        m.setPackagesToScan(new String[] {"com.realdolmen.education.xml"});
        return m;
    }
}
