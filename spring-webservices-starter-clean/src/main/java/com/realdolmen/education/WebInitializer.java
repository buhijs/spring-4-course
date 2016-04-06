package com.realdolmen.education;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.ws.transport.http.MessageDispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

public class WebInitializer implements WebApplicationInitializer {
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        AnnotationConfigWebApplicationContext applicationContext = new AnnotationConfigWebApplicationContext();
        applicationContext.register(WebConfiguration.class);
        ServletRegistration.Dynamic servlet = servletContext.addServlet("messageDispatcher", new MessageDispatcherServlet(applicationContext));
        servlet.setInitParameter("transformWsdlLocations", "true");
        servlet.setLoadOnStartup(1);
        servlet.addMapping("/");
    }
}
