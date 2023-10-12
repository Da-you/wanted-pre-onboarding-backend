package com.wanted.intership;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class IntershipApplication {

	public static void main(String[] args) {
		SpringApplication.run(IntershipApplication.class, args);
	}

}
