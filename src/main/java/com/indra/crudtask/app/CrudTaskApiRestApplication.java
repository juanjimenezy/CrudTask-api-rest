package com.indra.crudtask.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class CrudTaskApiRestApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudTaskApiRestApplication.class, args);
	}

}
