package com.example.universiter.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.universiter.entities.Departement;

import com.example.universiter.repository.DepartementRepository;

import lombok.AllArgsConstructor;
@AllArgsConstructor
@Service
public class DepartementService {
    private DepartementRepository departementRepository;

        public Iterable<Departement> lister()
        {
            return this.departementRepository.findAll();
        } 
        public void creer(Departement departement){
       
            this.departementRepository.save(departement);
        }


    public Departement Lire(int id){
        Optional <Departement> departement = this.departementRepository.findById(id);
        if (departement.isPresent()) {
            return departement.get();
        }
        return null;
    }
    public void modifier(int id, Departement departement){
        Departement departementdb = this.Lire(id);
        if (departementdb.getIddepartement() == departement.getIddepartement()) {
            this.departementRepository.save(departementdb);  
        }

    }
    public Iterable<Departement> rechercher(){

        return this.departementRepository.findAll();
    }
    public void supprimer(int id){
        this.departementRepository.deleteById(id);
    }

}
