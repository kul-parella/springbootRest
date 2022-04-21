package com.example.springbootRest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@EnableAsync
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@ComponentScan(basePackages = {"com.example"})
public class SpringbootRestApplication {

	public static void main(String[] args) {

		System.out.println("Thread Name: "+ Thread.currentThread().getName());
		SpringApplication.run(SpringbootRestApplication.class, args);
	}

}
