package com.springjpa.estudandospringjpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class })
public class EstudandoSpringJpaApplication {
    public static void main(String... args) throws Exception {
        SpringApplication.run(EstudandoSpringJpaApplication.class, args);
    }


    public void run(String... args) throws Exception {

    }

}
