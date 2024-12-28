package com.example.universiter.Dto;

import com.example.universiter.entities.Filiere;

public record ClasseDto(
        Integer idclasse,
        String nomClasse,
        String codeClasse,
        Filiere filiere
) {
}
