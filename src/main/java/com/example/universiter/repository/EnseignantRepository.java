package com.example.universiter.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.universiter.entities.Enseignant;

public interface EnseignantRepository extends JpaRepository <Enseignant, Integer> {
    Enseignant findByEmail(String email);

}
