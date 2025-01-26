package com.example.app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.app.domain.Pregunta;
import com.example.app.services.CuestionarioService;

@Controller

public class TestController {

    @Autowired
    CuestionarioService cuestionarioService;

    // Método para mostrar el test
    @GetMapping("/test")
    public String showTest(Model model) {
        // Cargamos las preguntas desde el servicio
        cuestionarioService.cargarPreguntasFichero();

        // Obtenemos las preguntas
        List<Pregunta> preguntas = cuestionarioService.getPreguntas();

        // Añadimos las preguntas al modelo
        model.addAttribute("preguntas", preguntas);

        return "cuestionarioView";
    }

    @PostMapping("/test/respuestas")
    public String submitRespuestas(
            Model model,
            // Recibimos las respuestas individualmente
            // Usamos required = false por si se deja alguna pregunta en blanco
            @RequestParam(value = "respuesta_1", required = false) Integer respuesta1,
            @RequestParam(value = "respuesta_2", required = false) Integer respuesta2,
            @RequestParam(value = "respuesta_3", required = false) Integer respuesta3,
            @RequestParam(value = "respuesta_3", required = false) Integer respuesta4,
            @RequestParam(value = "respuesta_3", required = false) Integer respuesta5,
            @RequestParam(value = "respuesta_3", required = false) Integer respuesta6) {

        // Variable para almacenar la puntuación
        int puntuacion = 0;

        // Las preguntas no contestadas no puntúan

        if (respuesta1 != null && respuesta1 == cuestionarioService.numeroCorrecto(1)) {
            puntuacion++;
        }
        if (respuesta2 != null && respuesta2 == cuestionarioService.numeroCorrecto(2)) {
            puntuacion++;
        }
        if (respuesta3 != null && respuesta3 == cuestionarioService.numeroCorrecto(3)) {
            puntuacion++;
        }
        if (respuesta4 != null && respuesta4 == cuestionarioService.numeroCorrecto(4)) {
            puntuacion++;
        }
        if (respuesta5 != null && respuesta5 == cuestionarioService.numeroCorrecto(5)) {
            puntuacion++;
        }
        if (respuesta6 != null && respuesta6 == cuestionarioService.numeroCorrecto(6)) {
            puntuacion++;
        }

        // Pasamos la puntuación al modelo
        model.addAttribute("puntuacion", puntuacion);

        return "puntuacionView";
    }

}
