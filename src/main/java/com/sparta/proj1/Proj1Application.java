package com.sparta.proj1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class Proj1Application {

    public static void main(String[] args) {
        SpringApplication.run(Proj1Application.class, args);
    }

}
