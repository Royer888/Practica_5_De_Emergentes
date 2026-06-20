package com.example.Pelicula_api;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(
        info = @Info(
                title = "API REST de Películas - Roger Flores Choque",
                version = "1.0",
                description = """
        API REST para la gestión de películas.
        Desarrollada con Spring Boot, PostgreSQL y Swagger.

        INTEGRANTE:
        • Roger Flores Choque

        Materia: Tecnologías Emergentes - Gestión 2026
        """
        )
)
public class PeliculaApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(PeliculaApiApplication.class, args);
    }
}