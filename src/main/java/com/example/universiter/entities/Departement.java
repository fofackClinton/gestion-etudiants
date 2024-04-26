
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
@Table(name = "departement")
@NamedQueries({
    @NamedQuery(name = "Departement.findAll", query = "SELECT d FROM Departement d"),
    @NamedQuery(name = "Departement.findByIddepartement", query = "SELECT d FROM Departement d WHERE d.iddepartement = :iddepartement"),
    @NamedQuery(name = "Departement.findByNomDepartement", query = "SELECT d FROM Departement d WHERE d.nomDepartement = :nomDepartement")})
public class Departement {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id_departement")
    private Integer iddepartement;
    private String nomDepartement;

   
}
