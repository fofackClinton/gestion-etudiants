package com.example.universiter.mapper;

import com.example.universiter.Dto.ClasseDto;
import com.example.universiter.entities.Classe;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class ClasseDtoMapper implements Function<Classe, ClasseDto> {
    @Override
    public ClasseDto apply(Classe classe) {
        return new ClasseDto(classe.getIdclasse(), classe.getNomClasse(), classe.getCodeClasse(), classe.getFiliere());
    }
}
