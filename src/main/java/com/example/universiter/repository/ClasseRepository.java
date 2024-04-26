package com.example.universiter.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.universiter.entities.Classe;

public interface ClasseRepository extends JpaRepository <Classe, Integer> {

}
