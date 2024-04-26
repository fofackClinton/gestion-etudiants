package com.example.universiter.repository;



import java.util.List;
import java.util.Optional;


import org.springframework.data.jpa.repository.JpaRepository;

import com.example.universiter.entities.Rolee;
import com.example.universiter.entities.Utilisateur;



public interface UtilisateurRepository extends JpaRepository <Utilisateur, Integer> {
    Optional <Utilisateur> findByEmail(String email);
    List<Utilisateur> findByRolee(Optional<Rolee> rolee);
}
