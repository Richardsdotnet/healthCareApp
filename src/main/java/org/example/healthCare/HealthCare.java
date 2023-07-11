package org.example.healthCare;

import org.example.healthCare.models.User;
import org.example.healthCare.service.HealthCareUserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class HealthCare {
    public static void main(String[] args) {
        SpringApplication.run(HealthCare.class, args);
    }
}
