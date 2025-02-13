package com.project.AirlineReservationSystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "com.project")
@EnableJpaRepositories(basePackages = "com.project.dao")
public class AirlineReservationSystemApplication {
    public static void main(String[] args) {
        SpringApplication.run(AirlineReservationSystemApplication.class, args);
    }
}

