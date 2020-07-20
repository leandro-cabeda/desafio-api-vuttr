package com.api.vuttr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.*;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@EnableAutoConfiguration(
		exclude = {SecurityAutoConfiguration.class })
@ComponentScan
public class VuttrApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(VuttrApiApplication.class, args);
	}
}
