package com.epam.agentx.configuration

import java.util.Properties

import javax.sql.DataSource

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import org.springframework.jdbc.datasource.DriverManagerDataSource
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter
import org.springframework.transaction.annotation.EnableTransactionManagement

@Configuration
@EnableJpaRepositories("com.epam.agentx")
@EnableTransactionManagement
class SpringDataSourceConfiguration {

    @Bean
    fun dataSource(): DataSource {
        return DriverManagerDataSource("jdbc:mysql://localhost:3306/eventrecorderserver", "root", "root")
    }

    @Bean
    fun entityManagerFactory(): LocalContainerEntityManagerFactoryBean {
        val em = LocalContainerEntityManagerFactoryBean()
        em.dataSource = dataSource()
        em.setPackagesToScan(*arrayOf("com.epam.eventrecorder"))

        val vendorAdapter = HibernateJpaVendorAdapter()
        em.jpaVendorAdapter = vendorAdapter
        em.setJpaProperties(additionalProperties())

        return em
    }

    internal fun additionalProperties(): Properties {
        val properties = Properties()
        properties.setProperty("hibernate.hbm2ddl.auto", "update")
        properties.setProperty("hibernate.show_sql", "true")
        properties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect")
        return properties
    }

}