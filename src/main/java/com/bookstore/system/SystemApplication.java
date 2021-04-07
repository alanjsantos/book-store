package com.bookstore.system;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableWebMvc
public class SystemApplication  {

	public static void main(String[] args) {
		SpringApplication.run(SystemApplication.class, args);
	}

}
