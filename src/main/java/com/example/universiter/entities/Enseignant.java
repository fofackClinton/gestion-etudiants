
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
@Table(name = "enseignant")
@NamedQueries({
    @NamedQuery(name = "Enseignant.findAll", query = "SELECT e FROM Enseignant e"),
    @NamedQuery(name = "Enseignant.findByIdenseignant", query = "SELECT e FROM Enseignant e WHERE e.idenseignant = :idenseignant"),
    @NamedQuery(name = "Enseignant.findByNom", query = "SELECT e FROM Enseignant e WHERE e.nom = :nom"),
    @NamedQuery(name = "Enseignant.findByPrenom", query = "SELECT e FROM Enseignant e WHERE e.prenom = :prenom"),
    @NamedQuery(name = "Enseignant.findByAdress", query = "SELECT e FROM Enseignant e WHERE e.adress = :adress"),
    @NamedQuery(name = "Enseignant.findByTelephone", query = "SELECT e FROM Enseignant e WHERE e.telephone = :telephone"),
    @NamedQuery(name = "Enseignant.findByEmail", query = "SELECT e FROM Enseignant e WHERE e.email = :email")})
public class Enseignant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idenseignant;
    private String nom;
    private String prenom;
    private String adress;
    private String telephone;
    private String email;
    @ManyToOne
    @JoinColumn(name = "Id_departement", referencedColumnName = "Id_departement")
    private Departement departement;   
}
