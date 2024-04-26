package com.example.universiter.service;
import java.util.List;
import java.util.Optional;


import org.springframework.stereotype.Service;

import com.example.universiter.entities.Enseignant;
import com.example.universiter.repository.EnseignantRepository;



@Service
public class EnseignantService {
    private EnseignantRepository enseignantRepository;


        public EnseignantService(EnseignantRepository enseignantRepository) {
        this.enseignantRepository = enseignantRepository;
    }
        public void Crerr( Enseignant  enseignant)
        {
            Enseignant enseignantDb = this.enseignantRepository.findByEmail( enseignant.getEmail());
            if ( enseignantDb == null) {
                this.enseignantRepository.save( enseignant);
            }
        }
        public List<Enseignant> lister()
        {
            return this.enseignantRepository.findAll();
        } 
        public void creer( Enseignant  Enseignant){
         Enseignant  EnseignantDb = this.enseignantRepository.findByEmail( Enseignant.getEmail());
        if ( EnseignantDb == null) {
            this.enseignantRepository.save( Enseignant);
        }

    }
    public  Enseignant Lire(int id){
        Optional < Enseignant>  Enseignant = this.enseignantRepository.findById(id);
        if ( Enseignant.isPresent()) {
            return  Enseignant.get();
        }
        return null;
    }
    public void modifier(int id,  Enseignant  enseignant){
         Enseignant  enseignantdb = this.Lire(id);
        if ( enseignantdb.getIdenseignant() ==  enseignant.getIdenseignant()) {
             enseignantdb.setEmail( enseignant.getEmail());
             enseignantdb.setNom( enseignant.getNom());
            this.enseignantRepository.save( enseignantdb);  
        }

    }
    public List< Enseignant> rechercher(){

        return this.enseignantRepository.findAll();
    }
    public void supprimer(int id){
        this.enseignantRepository.deleteById(id);
    }

}
