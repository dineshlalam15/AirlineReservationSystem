package com.project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import io.github.cdimascio.dotenv.Dotenv;

@SpringBootApplication(scanBasePackages = "com.project")
public class AirlineReservationSystemApplication {
    public static void main(String[] args) {
        Dotenv dotenv = Dotenv.configure().ignoreIfMissing().load();

        setSystemProperty("DB_URL", dotenv.get("DB_URL"));
        setSystemProperty("DB_USERNAME", dotenv.get("DB_USERNAME"));
        setSystemProperty("DB_PASSWORD", dotenv.get("DB_PASSWORD"));

        SpringApplication.run(AirlineReservationSystemApplication.class, args);
    }

    private static void setSystemProperty(String key, String value) {
        if (value != null && !value.isEmpty()) {
            System.setProperty(key, value);
        }
    }
}
