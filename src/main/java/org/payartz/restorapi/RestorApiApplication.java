package org.payartz.restorapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan("model")
@ComponentScan(basePackages = {"org.payartz.restorapi", "controller", "services", "config","repository"})
@EnableJpaRepositories("repository")
public class RestorApiApplication {
    public static void main(String[] args) {
        SpringApplication.run(RestorApiApplication.class, args);
    }
}

