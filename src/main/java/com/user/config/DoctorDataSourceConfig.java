package com.user.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import jakarta.persistence.EntityManagerFactory;

@Configuration
@EnableJpaRepositories(
    basePackages = "com.user.repository.doctor", // Replace with your Doctor repository package
    entityManagerFactoryRef = "doctorEntityManagerFactory",
    transactionManagerRef = "doctorTransactionManager"
)
public class DoctorDataSourceConfig {

    @Primary
    @Bean(name = "doctorDataSourceProperties")
    @ConfigurationProperties("spring.datasource.doctor")
    public DataSourceProperties doctorDataSourceProperties() {
        return new DataSourceProperties();
    }

    @Primary
    @Bean(name = "doctorDataSource")
    @ConfigurationProperties("spring.datasource.doctor")
    public DataSource doctorDataSource(@Qualifier("doctorDataSourceProperties") DataSourceProperties doctorDataSourceProperties) {
        return doctorDataSourceProperties.initializeDataSourceBuilder().build();
    }

    @Primary
    @Bean(name = "doctorEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean doctorEntityManagerFactory(
            @Qualifier("doctorDataSource") DataSource doctorDataSource) {
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(doctorDataSource);
        em.setPackagesToScan("com.user.entity"); // Replace with your Doctor entity package
        em.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        return em;
    }

    @Primary
    @Bean(name = "doctorTransactionManager")
    public PlatformTransactionManager doctorTransactionManager(
            @Qualifier("doctorEntityManagerFactory") EntityManagerFactory doctorEntityManagerFactory) {
        return new JpaTransactionManager(doctorEntityManagerFactory);
    }
}
