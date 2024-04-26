package com.example.universiter.service;


import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.universiter.entities.Etudiant;
import com.example.universiter.repository.EtudiantRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class EtudiantService {
    private EtudiantRepository etudiantRepository;


        public void Crerr(Etudiant etudiant)
        {
            Etudiant etudiantDb = this.etudiantRepository.findByEmail(etudiant.getEmail());
            if (etudiantDb == null) {
                this.etudiantRepository.save(etudiant);
            }
        }
        public Iterable<Etudiant> lister()
        {
            return this.etudiantRepository.findAll();
        } 
        public void creer(Etudiant etudiant){
        Etudiant etudiantDb = this.etudiantRepository.findByEmail(etudiant.getEmail());
        if (etudiantDb == null) {
            this.etudiantRepository.save(etudiant);
        }

    }
    public Etudiant Lire(int id){
        Optional <Etudiant> etudiant = this.etudiantRepository.findById(id);
        if (etudiant.isPresent()) {
            return etudiant.get();
        }
        return null;
    }
    public void modifier(int id, Etudiant etudiant){
        Etudiant etudiantdb = this.Lire(id);
        if (etudiantdb.getIdetudiant() == etudiant.getIdetudiant()) {
            etudiantdb.setEmail(etudiant.getEmail());
            etudiantdb.setNom(etudiant.getNom());
            this.etudiantRepository.save(etudiantdb);  
        }

    }
    public Iterable<Etudiant> rechercher(){

        return this.etudiantRepository.findAll();
    }
    public void supprimer(int id){
        this.etudiantRepository.deleteById(id);
    }

 

}
