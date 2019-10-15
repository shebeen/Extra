package com.app.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.vendor.HibernateJpaSessionFactoryBean;

import com.app.dao.TransactionDao;
import com.app.dao.TransactionDaoImpl;

@Configuration
@ComponentScan("com.app.dao")
public class DaoConf {
	@Bean
	 public TransactionDao transactionDao() {
       return new TransactionDaoImpl();
   }
	@Bean
	public HibernateJpaSessionFactoryBean sessionFactory() {
		return new HibernateJpaSessionFactoryBean();
	}
}
