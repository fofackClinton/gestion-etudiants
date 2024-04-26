/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.universiter.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "filiere")
@NamedQueries({
    @NamedQuery(name = "Filiere.findAll", query = "SELECT f FROM Filiere f"),
    @NamedQuery(name = "Filiere.findByIdfiliere", query = "SELECT f FROM Filiere f WHERE f.idfiliere = :idfiliere"),
    @NamedQuery(name = "Filiere.findByNom", query = "SELECT f FROM Filiere f WHERE f.nom = :nom")})
public class Filiere {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idfiliere;
    private String nom;
    @ManyToOne
    @JoinColumn(name = "Id_departement")
    private Departement departement;
   

    
}
