package com.realdolmen.education;

import com.realdolmen.education.xml.Employee;
import com.realdolmen.education.xml.Holiday;
import com.realdolmen.education.xml.HolidayRequest;
import com.realdolmen.education.xml.HolidayResponse;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.ws.client.core.WebServiceTemplate;

import java.net.URL;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * For these unit tests to work, you must start your web application first.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TestConfiguration.class)
public class HolidayServiceEndpointClientTest {
    private static final String WEB_SERVICE_LOCATION = "http://localhost:8080/";

    @Autowired(required = false)
    private WebServiceTemplate holidayServiceTemplate;

    @Test
    public void testWebServiceTemplateIsAvailable() throws Exception {
        assertNotNull("A WebServiceTemplate was not found. You should configure one!", holidayServiceTemplate);
        assertEquals(WEB_SERVICE_LOCATION + "holidayService", holidayServiceTemplate.getDefaultUri());
    }

    @Test
    public void holidayServiceIsConsumableWithGoodRequest() throws Exception {
        HolidayResponse response = (HolidayResponse) holidayServiceTemplate.marshalSendAndReceive(buildHolidayRequest("Jimi", "Hendrix", "JH010", "2014-12-10", "2014-12-30"));
        assertEquals("Success", response.getResult());
    }

    @Test
    public void holidayServiceIsConsumableWithBadRequest() throws Exception {
        HolidayResponse response = (HolidayResponse) holidayServiceTemplate.marshalSendAndReceive(buildHolidayRequest("Janis", "Joplin", "JJ010", null, null));
        assertEquals("Invalid date range", response.getResult());
    }

    @Test
    public void holidayServiceExposesWsdl() throws Exception {
        new URL(WEB_SERVICE_LOCATION + "holidayService.wsdl").getContent();
    }

    private HolidayRequest buildHolidayRequest(String firstName, String lastName, String employeeNumber, String startDate, String endDate) {
        HolidayRequest request = new HolidayRequest();
        Employee employee = new Employee();
        employee.setFirstName(firstName);
        employee.setLastName(lastName);
        employee.setNumber(employeeNumber);
        request.setEmployee(employee);
        Holiday holiday = new Holiday();
        holiday.setStartDate(startDate);
        holiday.setEndDate(endDate);
        request.setHoliday(holiday);
        return request;
    }
}
