package com.example.demo.config;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import jakarta.persistence.EntityManagerFactory;

@Configuration
@EnableJpaRepositories(
    basePackages = "com.example.demo.repository.offer",     entityManagerFactoryRef = "mysqlEMF",
    transactionManagerRef = "mysqlTxMgmr"
)
@EnableTransactionManagement
public class MySQLDBConfig {

    @Bean("mysqlDS")
    @ConfigurationProperties(prefix = "mysql.datasource")
    public DataSource createMySQLDs() {
        return DataSourceBuilder.create().build(); 
    }
    
    @Bean("mysqlEMF")
    public LocalContainerEntityManagerFactoryBean createLCMEFBForMySQL(EntityManagerFactoryBuilder emBuilder) {
        Map<String, Object> map = new HashMap<String, Object>(); 
        
        map.put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect"); 
        map.put("hibernate.hbm2ddl.auto", "update"); 
        map.put("hibernate.show_sql", "true"); 
        map.put("hibernate.format_sql", "true"); 
        
        return emBuilder
                .dataSource(createMySQLDs())
                .packages("com.example.demo.entity.offer") 
                .properties(map)
                .build(); 
    }
    
    @Bean("mysqlTxMgmr")
    public PlatformTransactionManager createTxnManagerForMySQL(@Qualifier("mysqlEMF") EntityManagerFactory factory) {
        return new JpaTransactionManager(factory); 
    }
}
