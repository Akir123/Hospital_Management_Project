package com.user.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import jakarta.persistence.EntityManagerFactory;

@Configuration
@EnableJpaRepositories(
    basePackages = "com.user.repository.patient", // Replace with your Patient repository package
    entityManagerFactoryRef = "patientEntityManagerFactory",
    transactionManagerRef = "patientTransactionManager"
)
public class PatientDataSourceConfig {

    @Bean(name = "patientDataSourceProperties")
    @ConfigurationProperties("spring.datasource.patient")
    public DataSourceProperties patientDataSourceProperties() {
        return new DataSourceProperties();
    }

    @Bean(name = "patientDataSource")
    @ConfigurationProperties("spring.datasource.patient")
    public DataSource patientDataSource(@Qualifier("patientDataSourceProperties") DataSourceProperties patientDataSourceProperties) {
        return patientDataSourceProperties.initializeDataSourceBuilder().build();
    }

    @Bean(name = "patientEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean patientEntityManagerFactory(
            @Qualifier("patientDataSource") DataSource patientDataSource) {
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(patientDataSource);
        em.setPackagesToScan("com.user.entity"); // Replace with your Patient entity package
        em.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        return em;
    }

    @Bean(name = "patientTransactionManager")
    public PlatformTransactionManager patientTransactionManager(
            @Qualifier("patientEntityManagerFactory") EntityManagerFactory patientEntityManagerFactory) {
        return new JpaTransactionManager(patientEntityManagerFactory);
    }
}
