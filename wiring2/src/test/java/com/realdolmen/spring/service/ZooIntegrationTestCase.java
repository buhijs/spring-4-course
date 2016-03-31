package com.realdolmen.spring.service;

import com.realdolmen.spring.config.TestConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.context.annotation.Profile;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = TestConfig.class)
@ActiveProfiles("test")
public class ZooIntegrationTestCase {

    @Autowired
    private Zoo zoo;

    @Test
    public void shouldHaveAntwerpZooPropertiesFilledIn() {
        assertThat(zoo.getName(), is("Pairi Testing Daiza"));
        // TODO assert the Zoo values come from the test properties
        assertThat(zoo.getOwnerName(), is("Nicolas' TestName"));
        assertThat(zoo.getTicketPrice(), is(99.0));
    }
}
