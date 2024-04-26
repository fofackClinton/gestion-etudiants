package com.example.universiter.repository;



import org.springframework.data.repository.CrudRepository;

import com.example.universiter.entities.Etudiant;

public interface EtudiantRepository  extends CrudRepository <Etudiant, Integer> {
   
    Etudiant findByEmail(String email);

}
