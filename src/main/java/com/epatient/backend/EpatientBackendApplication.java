package com.epatient.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.epatient.backend.repository")
@EntityScan("com.epatient.backend.model.dao")
public class EpatientBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(EpatientBackendApplication.class, args);
	}
}
