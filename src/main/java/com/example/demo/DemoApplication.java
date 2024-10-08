package com.example.demo;

import org.apache.camel.ProducerTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.example"})
public class DemoApplication {

	@Autowired
	ProducerTemplate producerTemplate;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}
