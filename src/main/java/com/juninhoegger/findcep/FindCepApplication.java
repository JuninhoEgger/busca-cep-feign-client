package com.juninhoegger.findcep;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableFeignClients
@EnableWebMvc
@SpringBootApplication
public class FindCepApplication {

	public static void main(String[] args) {
		SpringApplication.run(FindCepApplication.class, args);
	}

}
