package com.rahul.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.rahul.filter.RequestTakingInterceptor;

@Configuration
public class AppConfig extends WebMvcConfigurerAdapter{
	
	@Autowired
	private RequestTakingInterceptor RequestTakingInterceptor;
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(RequestTakingInterceptor);
	}

}
