package com.AlumnosPortatiles.project.app;

import java.beans.PropertyVetoException;
import java.util.Properties;
import java.util.logging.Logger;

import javax.sql.DataSource;

// import org.apache.commons.logging.Log;
// import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import com.mchange.v2.c3p0.ComboPooledDataSource;


@Configuration
@ComponentScan("com.AlumnosPortatiles.project")
@PropertySource("classpath:application.properties")
@EnableJpaRepositories(basePackages = "com.AlumnosPortatiles.project.app.repositories")
public class AppContextConfig {

	
	private Logger logger = Logger.getLogger(getClass().getName());
	
	@Autowired
	private Environment enviroment;
	
	
	@Bean
    public DataSource dataSource() {
    	DriverManagerDataSource dataSource = new DriverManagerDataSource();
    	
    	dataSource.setDriverClassName(enviroment.getProperty("spring.datasource.driverClassName"));
		dataSource.setUrl(enviroment.getProperty("spring.datasource.url"));
		dataSource.setUsername(enviroment.getProperty("spring.datasource.username"));
		dataSource.setPassword(enviroment.getProperty("spring.datasource.password"));
        
		return dataSource;
    }
	
	
	@Bean
	public DataSource seguridadDataSource() {
		// creación del pool de conexiones
		ComboPooledDataSource seguridadDataSource = new ComboPooledDataSource();

		// establecer el driver JDBC
    	try {
			seguridadDataSource.setDriverClass(enviroment.getProperty("spring.datasource.driverClassName"));
		} catch (PropertyVetoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	// hacer log de las propiedades de conexión
    	logger.info("DB URL: " + enviroment.getProperty("spring.datasource.url"));
    	logger.info("DB USER: " + enviroment.getProperty("spring.datasource.username"));
    	
    	// establecer propiedades de conexión con la BBDD
    	seguridadDataSource.setJdbcUrl(enviroment.getProperty("spring.datasource.url"));
    	seguridadDataSource.setUser(enviroment.getProperty("spring.datasource.username"));
    	seguridadDataSource.setPassword(enviroment.getProperty("spring.datasource.password"));
    	
    	// establecer las propiedades del pool de conexión
    	seguridadDataSource.setMinPoolSize(5);
    	seguridadDataSource.setMaxPoolSize(20);
    	seguridadDataSource.setInitialPoolSize(5);
    	seguridadDataSource.setMaxIdleTime(3000);
    	
    	return seguridadDataSource;
	}
	
	
	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		LocalContainerEntityManagerFactoryBean entityManagerFactory = new LocalContainerEntityManagerFactoryBean();
		entityManagerFactory.setDataSource(dataSource());
		entityManagerFactory.setPackagesToScan(new String[] {
			// Alumno.class.getPackage().getName()
			"com.AlumnosPortatiles.project.app.entities"
	    });
		
		HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		vendorAdapter.setDatabase(Database.POSTGRESQL);
		vendorAdapter.setDatabasePlatform(enviroment.getProperty("hibernate.dialect"));
		vendorAdapter.setGenerateDdl(enviroment.getProperty("hibernate.generateDdl", Boolean.class));
		vendorAdapter.setShowSql(enviroment.getProperty("hibernate.show_sql", Boolean.class));
		entityManagerFactory.setJpaVendorAdapter(vendorAdapter);
		
		Properties jpaProperties = new Properties();
		jpaProperties.put("hibernate.hbm2ddl.auto", enviroment.getProperty("hibernate.hbm2ddl.auto"));
        jpaProperties.put("hibernate.show_sql", enviroment.getProperty("hibernate.show_sql"));
        jpaProperties.put("hibernate.format_sql", enviroment.getProperty("hibernate.format_sql"));
        jpaProperties.put("hibernate.dialect", enviroment.getRequiredProperty("hibernate.dialect"));
        jpaProperties.setProperty("hibernate.cache.use_second_level_cache", enviroment.getProperty("hibernate.cache.use_second_level_cache"));
        jpaProperties.setProperty("hibernate.cache.use_query_cache", enviroment.getProperty("hibernate.cache.use_query_cache"));
        entityManagerFactory.setJpaProperties(jpaProperties);
		
		return entityManagerFactory;
	}
	
	
	@Bean
    public JpaTransactionManager transactionManager() {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());
        
        return transactionManager;
    }
	
}