package com.estate.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.estate")
public class ApplicationConfig {
	
	@Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
