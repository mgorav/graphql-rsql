package com.gonnect.graphql.configurer;

import com.gonnect.graphql.entities.MyPet;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.EclipseLinkJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Map;
import java.util.Properties;

import static java.lang.String.format;

/**
 * Setup EclipseLink
 */
@Configuration
@ConfigurationProperties(prefix = "spring.jpa")
@EnableTransactionManagement
@EnableAutoConfiguration(exclude = {HibernateJpaAutoConfiguration.class})
@Slf4j
public class EclipseLinkConfigurer {

    @Setter
    @Getter
    private Map<String, String> properties;

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource) {

        LocalContainerEntityManagerFactoryBean emfBean = new LocalContainerEntityManagerFactoryBean();

        emfBean.setDataSource(dataSource);
        emfBean.setJpaVendorAdapter(new EclipseLinkJpaVendorAdapter());
        emfBean.setPackagesToScan(MyPet.class.getPackage().getName());

        Properties properties = new Properties();

        this.properties.forEach((k, v) -> {
            properties.setProperty(k, v);
        });

        emfBean.setJpaProperties(properties);

        log.info(format("Configured JPA (EclipseLink) with properties: ",properties));

        return emfBean;
    }

    @Bean
    public PlatformTransactionManager transactionManager(EntityManagerFactory emf) {
        final JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(emf);
        return transactionManager;
    }

}