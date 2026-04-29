package com.nosuchelements.config;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

	@Configuration
	@ComponentScan(basePackages = {
	"com.nosuchelements.config",
	"com.nosuchelements.driver",
	"com.nosuchelements.pages",
	"com.nosuchelements.api",
	"com.nosuchelements.accessibility",
	"com.nosuchelements.utils",
	"com.springbootjdbc.com.spring.jdbc.*",
	"com.springbootjdbc.com.spring.jdbc.profile.*"
	})
	@PropertySource({
	"classpath:application.properties",
	"classpath:application-saucelabs.properties"
	})
	public class SpringConfig {
	// Configuration via annotations - no additional code needed
	}

