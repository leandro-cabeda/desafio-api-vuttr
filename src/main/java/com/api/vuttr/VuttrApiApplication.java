package com.api.vuttr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.*;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication(scanBasePackages = {"com.api.vuttr.helper"})
@EnableAutoConfiguration
@ComponentScan
public class VuttrApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(VuttrApiApplication.class, args);
	}
}
