package com.app.configuration;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.hibernate.jpa.HibernateEntityManagerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.app.dao.TransactionDao;
import com.app.dao.TransactionDaoImpl;

@Configuration
@ComponentScan("com.app.dao")
public class DaoConf {


//	@Value("${db.driver}")
//	private String DB_DRIVER;
//
//	@Value("${db.password}")
//	private String DB_PASSWORD;
//
//	@Value("${db.url}")
//	private String DB_URL;
//
//	@Value("${db.username}")
//	private String DB_USERNAME;
//
//	@Value("${hibernate.dialect}")
//	private String HIBERNATE_DIALECT;
//
//	@Value("${hibernate.show_sql}")
//	private String HIBERNATE_SHOW_SQL;
//
//	@Value("${hibernate.hbm2ddl.auto}")
//	private String HIBERNATE_HBM2DDL_AUTO;
//
//	@Value("${entitymanager.packagesToScan}")
//	private String ENTITYMANAGER_PACKAGES_TO_SCAN;

	@Bean
	public LocalSessionFactoryBean sessionFactory() {
		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
		sessionFactory.setDataSource(dataSource());
		sessionFactory.setPackagesToScan("com.app.model");
		Properties hibernateProperties = new Properties();
		hibernateProperties.put("hibernate.dialect", "org.hibernate.dialect.MySQL5InnoDBDialect");
		hibernateProperties.put("hibernate.show_sql", "true");
		hibernateProperties.put("hibernate.hbm2ddl.auto", "update");
		sessionFactory.setHibernateProperties(hibernateProperties);
		return sessionFactory;
	}

	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/extra");
		dataSource.setUsername("root");
		return dataSource;
	}

//	    @Bean
//	    public HibernateTransactionManager transactionManager() {
//	        HibernateTransactionManager txManager = new HibernateTransactionManager();
//	        txManager.setSessionFactory(sessionFactory().getObject());
//	        return txManager;
//	    }

}
