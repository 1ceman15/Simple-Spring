package com.iceman.simplespring;

import com.iceman.simplespring.repository.EmployerRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SimpleSpringApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(SimpleSpringApplication.class, args);
    }

}
