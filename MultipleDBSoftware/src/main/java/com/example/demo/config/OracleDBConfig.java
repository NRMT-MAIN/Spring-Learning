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
		basePackages = "com.example.demo.repository.prod" ,
		entityManagerFactoryRef = "oraEMF",
	    transactionManagerRef = "oraTxMgmr"
)
@EnableTransactionManagement
public class OracleDBConfig {

	@Bean("oraDS")
    @ConfigurationProperties(prefix = "oracle.datasource")
	@Primary
	public DataSource createOraDs() {
		return DataSourceBuilder.create().build() ; 
	}
	
	@Bean("oraEMF")
	public LocalContainerEntityManagerFactoryBean createLCMEFBForOracle(EntityManagerFactoryBuilder emBuilder) {
		Map<String, Object> map = new HashMap<String , Object>() ; 
		
		map.put("hibernate.dialect", "org.hibernate.dialect.OracleDialect") ; 
		map.put("hibernate.hbm2ddl.auto", "update") ; 
		map.put("hibernate.show_sql", "true") ; 
		map.put("hibernate.format_sql", "true") ; 
		
		return emBuilder
				.dataSource(createOraDs())
				.packages("com.example.demo.entity.prod")
				.properties(map)
				.build() ; 
	}
	
	@Bean("oraTxMgmr")
	public PlatformTransactionManager createTxnManagerForOracle(@Qualifier("oraEMF") EntityManagerFactory factory) {
		return new JpaTransactionManager(factory) ; 
	}
}
