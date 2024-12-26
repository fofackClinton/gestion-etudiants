package com.example.universiter.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Stream;

import com.example.universiter.Dto.ClasseDto;
import com.example.universiter.mapper.ClasseDtoMapper;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import com.example.universiter.entities.Classe;

import com.example.universiter.repository.ClasseRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ClasseService {
    private ClasseDtoMapper classeDtoMapper;
    private ClasseRepository classeRepository;


    public Stream<ClasseDto> lister()
        {return this.classeRepository.findAll().stream().map(classeDtoMapper);}

    public void creer(Classe classe){this.classeRepository.save(classe);}


    public Classe Lire(int id){
        Optional <Classe> classe = this.classeRepository.findById(id);
        return classe.orElseThrow(
                () -> new EntityNotFoundException("La classe n'existe pas")
        );
    }
    public void modifier(int id, Classe classe){
        Classe classedb = this.Lire(id);
        if (Objects.equals(classedb.getIdclasse(), classe.getIdclasse())) {
            classedb.setCodeClasse(classe.getCodeClasse());
            classedb.setNomClasse(classe.getNomClasse());
            this.classeRepository.save(classedb);
        }else throw new EntityNotFoundException("La classe n'existe pas");

    }
    public Iterable<Classe> rechercher(){

        return this.classeRepository.findAll();
    }
    public void supprimer(int id){
        this.classeRepository.deleteById(id);
    }

}
