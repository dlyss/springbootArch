package com.baike.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.baike")
public class SpringbootArchApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootArchApplication.class, args);
	}
}
