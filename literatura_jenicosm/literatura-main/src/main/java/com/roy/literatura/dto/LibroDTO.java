package com.roy.literatura.dto;

import com.roy.literatura.model.Lenguaje;

public record LibroDTO(
        Long id,
        String titulo,
        Lenguaje idiomas,
        Integer totalDescargas
) {
}
