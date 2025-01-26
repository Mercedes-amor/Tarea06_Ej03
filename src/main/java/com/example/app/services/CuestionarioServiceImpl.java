package com.example.app.services;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.app.domain.Pregunta;

@Service
public class CuestionarioServiceImpl implements CuestionarioService {

    private List<Pregunta> preguntasRepository = new ArrayList<>();

    // Método para cargar la información desde el csv
    public void cargarPreguntasFichero() {
        try {

            // Limpiamos el ArrayList antes de cargar nuevas preguntas,
            //Ya que si no añade nuevamente las preguntas y salen duplicadas.
            preguntasRepository.clear();

            // Leemos todas las líneas del archivo
            List<String> lineas = Files.readAllLines(Paths.get("Ej03/src/main/resources/static/preguntasIndiana.csv"),
                    StandardCharsets.UTF_8);
            System.out.println("Preguntas cargadas correctamente");

            for (String linea : lineas) {
                try {
                    // Usamos ; como delimitador
                    String[] preguntaInfo = linea.split(";");

                    // Procesamos la línea, nos irá devolviendo una instancia de Pregunta
                    // que es un array con 7 elementos.
                    // [numeroPregunta, pregunta, resp1, resp2, resp3, resp4, respCorrecta]
                    int numeroPregunta = Integer.parseInt(preguntaInfo[0].trim());
                    String pregunta = preguntaInfo[1].trim();
                    String resp1 = preguntaInfo[2].trim();
                    String resp2 = preguntaInfo[3].trim();
                    String resp3 = preguntaInfo[4].trim();
                    String resp4 = preguntaInfo[5].trim();
                    int respCorrecta = Integer.parseInt(preguntaInfo[6].trim());

                    // Creamos el objeto Pregunta y lo añadimos al repositorio
                    preguntasRepository
                            .add(new Pregunta(numeroPregunta, pregunta, resp1, resp2, resp3, resp4, respCorrecta));

                } catch (Exception e) {
                    System.err.println("Error al leer el archivo preguntasIndiana.csv: " + e.getMessage());
                }
            }
        } catch (IOException e) {
            System.err.println("Error al leer el archivo csv: " + e.getMessage());
        }
    }

    // Método para obtener las preguntas, devuelve el Array
    public List<Pregunta> getPreguntas() {
        return preguntasRepository;
    }

    // Método para obtener el número de la respuesta correcta
    public int numeroCorrecto(int numeroPregunta) {
        int respCorrecta = -1;
        for (Pregunta pregunta : preguntasRepository) {
            if (pregunta.getNumeroPregunta() == numeroPregunta) {
                respCorrecta = pregunta.getRespCorrecta();
            }
        }
        return respCorrecta;
    }
}
