package com.app.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.app.service.TransactionService;
import com.app.service.TransactionServiceImpl;

@Configuration
@ComponentScan("com.app.service")
public class ServiceConf {
	@Bean
	public TransactionService transactionService() {
		return new TransactionServiceImpl();
	}
}
