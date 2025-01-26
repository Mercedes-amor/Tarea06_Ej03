package com.example.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.app.services.CuestionarioService;

@SpringBootApplication

public class Main {

	@Autowired
	CuestionarioService cuestionarioService;

	public static void main(String[] args) {
		SpringApplication.run(Main.class, args);
		System.out.println("Tarea 6 Repositorios, Test Indiana Jones");
	}

	//No nos hace falta cargar las preguntas con el Bean
	// Bean CommandLineRunner para cargar los datos iniciales
	// @Bean
	// CommandLineRunner initData(CuestionarioService cuestionarioService) {
	// 	return args -> {
	// 		// Llamamos al método del service para cargar las preguntas
	// 		cuestionarioService.cargarPreguntasFichero();

	// 		System.out.println("Datos de preguntas cargados: ");
	// 	};
	// }

}
