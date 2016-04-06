package com.realdolmen.education.endpoint;

import com.realdolmen.education.service.HolidayService;
import com.realdolmen.education.xml.HolidayRequest;
import com.realdolmen.education.xml.HolidayResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

// TODO: This will be your service endpoint. The Java code is all good, but you should still add the right annotations to make it work!
@Endpoint
public class HolidayServiceEndpoint {
    @Autowired
    private HolidayService holidayService;

    @PayloadRoot(localPart = "HolidayRequest", namespace = "http://education.realdolmen.com/spring-webservices/domain")
    public @ResponsePayload HolidayResponse requestHoliday(@RequestPayload HolidayRequest request) {
        String result = holidayService.requestHoliday(request.getEmployee().getFirstName(), request.getEmployee().getLastName(), request.getEmployee().getNumber(), request.getHoliday().getStartDate(), request.getHoliday().getEndDate());
        HolidayResponse response = new HolidayResponse();
        response.setResult(result);
        return response;
    }
}
