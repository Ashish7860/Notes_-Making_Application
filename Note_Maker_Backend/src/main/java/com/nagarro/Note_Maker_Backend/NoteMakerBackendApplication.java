package com.nagarro.Note_Maker_Backend;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
@EntityScan("com.nagarro.Note_Maker_Backend.entity;")


public class NoteMakerBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(NoteMakerBackendApplication.class, args);
	}

}
