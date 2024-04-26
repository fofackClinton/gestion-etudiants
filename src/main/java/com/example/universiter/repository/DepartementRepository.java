package com.example.universiter.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.universiter.entities.Departement;

public interface DepartementRepository extends JpaRepository <Departement, Integer>  {

}
