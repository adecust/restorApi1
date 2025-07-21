package org.payartz.restorapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan("org.payartz.restorapi.model.entity")
@EnableJpaRepositories("org.payartz.restorapi.repository")
public class RestorApiApplication {
    public static void main(String[] args) {
        SpringApplication.run(RestorApiApplication.class, args);
    }
}


