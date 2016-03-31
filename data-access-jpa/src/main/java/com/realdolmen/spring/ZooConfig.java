package com.realdolmen.spring;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Profile;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

@ComponentScan
@EnableTransactionManagement
public class ZooConfig {
    @Bean
    public PlatformTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
        return new JpaTransactionManager(entityManagerFactory);
    }

    // TODO: Configure a DataSource for MySQL in the production profile (BasicDataSource)

    // TODO: configure an embedded DataSource for H2 in the test profile

    // TODO: Configure an EntityManagerFactory bean for use with Hibernate

    // TODO: Make sure your EntityManagerFactoryBean is set up for using dialect H2 in test and dialect MySQL in production
}
