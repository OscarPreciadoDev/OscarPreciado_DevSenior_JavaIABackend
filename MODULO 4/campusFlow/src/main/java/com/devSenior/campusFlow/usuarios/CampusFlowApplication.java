package com.devSenior.campusFlow.usuarios;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = {"com.devSenior.campusFlow"})
@SpringBootApplication
public class CampusFlowApplication {
    public static void main(String[] args) {
        SpringApplication.run(CampusFlowApplication.class, args);
    }
}


// Hora de video clase 13: [1:34:24] // Tema: Arquitectura de proyecto, ajustes de variables de entorno
