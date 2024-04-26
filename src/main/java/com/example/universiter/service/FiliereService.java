package com.example.universiter.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.universiter.entities.Filiere;

import com.example.universiter.repository.FiliereRepository;


@Service
public class FiliereService {
    private FiliereRepository filiereRepository;

    public FiliereService(FiliereRepository filiereRepository) {
        this.filiereRepository = filiereRepository;
    }

        public Iterable<Filiere> lister()
        {
            return this.filiereRepository.findAll();
        } 
        public void creer(Filiere filiere){
       
            this.filiereRepository.save(filiere);
        }


    public Filiere Lire(int id){
        Optional <Filiere> filiere = this.filiereRepository.findById(id);
        if (filiere.isPresent()) {
            return filiere.get();
        }
        return null;
    }
    public void modifier(int id, Filiere filiere){
        Filiere filieredb = this.Lire(id);
        if (filieredb.getIdfiliere() == filiere.getIdfiliere()) {
            this.filiereRepository.save(filieredb);  
        }

    }
    public Iterable<Filiere> rechercher(){

        return this.filiereRepository.findAll();
    }
    public void supprimer(int id){
        this.filiereRepository.deleteById(id);
    }

}
