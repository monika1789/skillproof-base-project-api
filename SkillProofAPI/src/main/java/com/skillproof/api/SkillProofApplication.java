package com.skillproof.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = {"com.skillproof.*"})
@EntityScan(basePackages = {"com.skillproof.*"})
@EnableJpaRepositories(basePackages = {"com.skillproof.*"})
public class SkillProofApplication {

    public static void main(String[] args) {
        SpringApplication.run(SkillProofApplication.class, args);
    }
}
