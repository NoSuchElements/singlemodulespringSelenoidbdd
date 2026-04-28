package com.nosuchelements.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.retry.annotation.EnableRetry;

@SpringBootApplication
@EnableRetry
@ComponentScan(basePackages = "com.nosuchelements") 
public class singlemodulespringbddApplication {
    public static void main(String[] args) {
        SpringApplication.run(singlemodulespringbddApplication.class, args);
    }
}
