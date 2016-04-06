package com.realdolmen.spring.rest;

import com.realdolmen.spring.ZooConfig;
import com.realdolmen.spring.domain.Animal;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.hateoas.MediaTypes;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import org.springframework.hateoas.client.Traverson;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;

import static org.junit.Assert.assertEquals;
import static org.springframework.hateoas.client.Hop.rel;

// TODO Run this test after finishing up with Spring Data REST to check if you can have access from a Java client

@RunWith(SpringJUnit4ClassRunner.class)
@WebIntegrationTest
@SpringApplicationConfiguration(classes = ZooConfig.class)
@ActiveProfiles("test")
public class AnimalRESTTest {
    @SpringBootApplication
    static class Config {

    }

    @Test
    public void shouldFindTheFirstAnimal() {
        Traverson traverson = new Traverson(URI.create("http://localhost:8080/api"), MediaTypes.HAL_JSON);
        Traverson.TraversalBuilder builder = traverson.follow("animals");

        ParameterizedTypeReference<Resource<Animal>> resourceParameterizedTypeReference = new ParameterizedTypeReference<Resource<Animal>>() {};

        Resource<Animal> itemResource = builder.follow("$._embedded.animals[0]._links.self.href").toObject(resourceParameterizedTypeReference);
        assertEquals("Tigger", itemResource.getContent().getName());
    }
}
