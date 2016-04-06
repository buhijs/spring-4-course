package com.realdolmen.education.service;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class HolidayServiceBean implements HolidayService {
    private Log log = LogFactory.getLog(getClass());

    @Override
    public String requestHoliday(String firstName, String lastName, String employeeNumber, String start, String end) {
        if(start == null || end == null) {
            return "Invalid date range";
        }

        log.info(String.format("Registering holiday for %s %s (%s) from %s to %s", firstName, lastName, employeeNumber, start, end));
        return "Success";
    }
}
