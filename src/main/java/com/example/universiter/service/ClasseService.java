package com.example.universiter.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.universiter.entities.Classe;

import com.example.universiter.repository.ClasseRepository;

@Service
public class ClasseService {
    private ClasseRepository classeRepository;

    public ClasseService(ClasseRepository classeRepository) {
        this.classeRepository = classeRepository;
    }

        public Iterable<Classe> lister()
        {
            return this.classeRepository.findAll();
        } 
        public void creer(Classe classe){
       
            this.classeRepository.save(classe);
        }


    public Classe Lire(int id){
        Optional <Classe> classe = this.classeRepository.findById(id);
        if (classe.isPresent()) {
            return classe.get();
        }
        return null;
    }
    public void modifier(int id, Classe classe){
        Classe classedb = this.Lire(id);
        if (classedb.getIdclasse() == classe.getIdclasse()) {
            this.classeRepository.save(classedb);  
        }

    }
    public Iterable<Classe> rechercher(){

        return this.classeRepository.findAll();
    }
    public void supprimer(int id){
        this.classeRepository.deleteById(id);
    }

}
