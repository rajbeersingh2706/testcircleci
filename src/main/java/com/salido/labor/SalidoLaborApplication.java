package com.salido.labor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//-Dspring.profiles.active=qa
@SpringBootApplication
public class SalidoLaborApplication {
    public static void main(String[] args) {
        SpringApplication.run(SalidoLaborApplication.class, args);
    }
}
