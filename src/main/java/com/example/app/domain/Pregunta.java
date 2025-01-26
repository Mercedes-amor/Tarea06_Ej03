package com.example.app.domain;


import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;

import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pregunta {

    @NotNull
    private int numeroPregunta;
    @NotNull
    private String pregunta;
    @NotNull
    private String resp1;
    @NotNull
    private String resp2;
    @NotNull
    private String resp3;
    @NotNull
    private String resp4;
    @NotNull
    private int respCorrecta;
}
