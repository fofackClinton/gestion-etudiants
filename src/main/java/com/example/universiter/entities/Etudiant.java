
package com.example.universiter.entities;



import jakarta.persistence.*;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "etudiant")
@NamedQueries({
    @NamedQuery(name = "Etudiant.findAll", query = "SELECT e FROM Etudiant e"),
    @NamedQuery(name = "Etudiant.findByIdetudiant", query = "SELECT e FROM Etudiant e WHERE e.idetudiant = :idetudiant"),
    @NamedQuery(name = "Etudiant.findByName", query = "SELECT e FROM Etudiant e WHERE e.name = :name"),
    @NamedQuery(name = "Etudiant.findByEmail", query = "SELECT e FROM Etudiant e WHERE e.email = :email"),
    @NamedQuery(name = "Etudiant.findByNom", query = "SELECT e FROM Etudiant e WHERE e.nom = :nom"),
    @NamedQuery(name = "Etudiant.findByPrenom", query = "SELECT e FROM Etudiant e WHERE e.prenom = :prenom"),
    @NamedQuery(name = "Etudiant.findByAdresse", query = "SELECT e FROM Etudiant e WHERE e.adresse = :adresse"),
    @NamedQuery(name = "Etudiant.findByTelephone", query = "SELECT e FROM Etudiant e WHERE e.telephone = :telephone")})
public class Etudiant {

   
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idetudiant;
    private String name;
    private String email;
    private String nom;
    private String prenom;
    private String adresse;
    private String telephone;
    @ManyToOne
    @JoinColumn(name = "Id_classe")
    private Classe classe;

    
}
