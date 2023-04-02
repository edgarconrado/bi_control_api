package com.belz.bicontrol.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.sql.DriverManager;
import java.util.Properties;

@Configuration
@PropertySource({"classpath:biControlApi.properties"})
@EnableTransactionManagement
@EnableJpaRepositories("com.belz.bicontrol.repository")
public class DBConfig {

    @Autowired
    private Environment environment;

    @Bean
    public DataSource dataSource(){
        DriverManagerDataSource ds = new DriverManagerDataSource();
        ds.setDriverClassName(environment.getRequiredProperty("spring.datasource.driverClassName"));
        ds.setUrl(environment.getRequiredProperty("spring.datasource.url"));
        ds.setUsername(environment.getRequiredProperty("spring.datasource.username"));
        ds.setPassword(environment.getRequiredProperty("spring.datasource.password"));
        return ds;
    }
    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        //vendorAdapter.setShowSql(env.getProperty("hibernate.show_sql", Boolean.class));
        factory.setDataSource(dataSource());
        factory.setJpaVendorAdapter(vendorAdapter);
        factory.setPackagesToScan("com.belz.bicontrol.entity");
        Properties jpaProperties = new Properties();
        jpaProperties.put("hibernate.hbm2ddl.auto","none");
        jpaProperties.put("hibernate.default_schema",environment.getRequiredProperty("spring.jpa.hibernate.schema"));
        jpaProperties.put("hibernate.physical_naming_strategy","com.vladmihalcea.hibernate.type.util.CamelCaseToSnakeCaseNamingStrategy");
        jpaProperties.put("hibernate.dialect","org.hibernate.dialect.SQLServerDialect");
        jpaProperties.put("hibernate.show_sql",true);
        factory.setJpaProperties(jpaProperties);
        return factory;
    }

}
