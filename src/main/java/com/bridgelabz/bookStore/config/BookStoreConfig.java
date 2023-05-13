package com.bridgelabz.bookStore.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.SimpleMailMessage;

@Configuration
public class BookStoreConfig {
	
	@Bean
	ModelMapper modelMapper() {
		return new ModelMapper();
	}
	
	@Bean
	SimpleMailMessage mailMessage() {
		return new SimpleMailMessage();
	}

}
