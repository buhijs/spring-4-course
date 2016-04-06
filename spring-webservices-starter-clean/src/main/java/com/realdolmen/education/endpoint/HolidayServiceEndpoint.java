package com.realdolmen.education.endpoint;

import com.realdolmen.education.service.HolidayService;
import com.realdolmen.education.xml.HolidayRequest;
import com.realdolmen.education.xml.HolidayResponse;
import org.springframework.beans.factory.annotation.Autowired;

// TODO: This will be your service endpoint. The Java code is all good, but you should still add the right annotations to make it work!
public class HolidayServiceEndpoint {
    @Autowired
    private HolidayService holidayService;

    public HolidayResponse requestHoliday(HolidayRequest request) {
        String result = holidayService.requestHoliday(request.getEmployee().getFirstName(), request.getEmployee().getLastName(), request.getEmployee().getNumber(), request.getHoliday().getStartDate(), request.getHoliday().getEndDate());
        HolidayResponse response = new HolidayResponse();
        response.setResult(result);
        return response;
    }
}
