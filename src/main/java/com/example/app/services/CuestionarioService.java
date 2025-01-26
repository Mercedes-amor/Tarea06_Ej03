package com.example.app.services;

import java.util.List;

import com.example.app.domain.Pregunta;

public interface CuestionarioService {
 
public void cargarPreguntasFichero();

public List<Pregunta> getPreguntas();

public int numeroCorrecto(int numeroPregunta);
}
