package com.realdolmen.spring;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jndi.JndiObjectFactoryBean;

import javax.sql.DataSource;

@SpringBootApplication
public class ZooConfig {
    // TODO: add a datasource for the production profile. We will use BasicDataSource from Apache DBCP.
    // TODO: Use connection properties for MySQL (url = "jdbc:mysql://localhost:3306/zoo", user = "root", password = "")
    @Profile("production")
    @Bean
    public DataSource dataSource() {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUsername("root");
        dataSource.setPassword("");
        dataSource.setUrl("jdbc:mysql://localhost:3306/zoo");
        return dataSource;
    }



    // TODO: add a JDBC template
    @Bean
    public JdbcTemplate jdbcTemplate(DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }

}
