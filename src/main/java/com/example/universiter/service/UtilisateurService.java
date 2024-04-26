package com.example.universiter.service;

import java.util.List;
import java.util.Optional;


import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.universiter.ennum.TypeRole;
import com.example.universiter.entities.Rolee;
import com.example.universiter.entities.Utilisateur;
import com.example.universiter.repository.RoleeRepository;
import com.example.universiter.repository.UtilisateurRepository;

import lombok.AllArgsConstructor;


@Service
@AllArgsConstructor
public class UtilisateurService implements UserDetailsService {
    private UtilisateurRepository utilisateurRepository;
    private RoleeRepository roleeRepository;
    private BCryptPasswordEncoder passwordEncoder;
    public void inscription(Utilisateur utilisateur)
    {
        if (!utilisateur.getEmail().contains("@") || !utilisateur.getEmail().contains(".") ) {
            throw new RuntimeException("cet adress mail n'est pas valide");
        }
        String mdpcript =this.passwordEncoder.encode(utilisateur.getMdp());
        utilisateur.setMdp(mdpcript);
        Optional <Utilisateur> utilisateurOptional = this.utilisateurRepository.findByEmail(utilisateur.getEmail());
        if (utilisateurOptional.isPresent()) {
            throw new RuntimeException("cet adress mail est deja utiliser");
            
        }
        Rolee roleUtilisateur = new Rolee();
        roleUtilisateur.setLibele(TypeRole.Etudiant);
        utilisateur.setRolee(roleUtilisateur);
        this.utilisateurRepository.save(utilisateur);

    }
    public void responsable(Utilisateur utilisateur)
    {
        if (!utilisateur.getEmail().contains("@") || !utilisateur.getEmail().contains(".") ) {
            throw new RuntimeException("cet adress mail n'est pas valide");
        }
        String mdpcript =this.passwordEncoder.encode(utilisateur.getMdp());
        utilisateur.setMdp(mdpcript);
        Optional <Utilisateur> utilisateurOptional = this.utilisateurRepository.findByEmail(utilisateur.getEmail());
        if (utilisateurOptional.isPresent()) {
            throw new RuntimeException("cet adress mail est deja utiliser");
            
        }
        Rolee roleUtilisateur = new Rolee();
        roleUtilisateur.setLibele(TypeRole.Responsable);
        utilisateur.setRolee(roleUtilisateur);
        this.utilisateurRepository.save(utilisateur);

    }
    public void creer(Utilisateur utilisateur){
        Optional <Utilisateur> utilisateurDb = this.utilisateurRepository.findByEmail(utilisateur.getEmail());
        if (utilisateurDb == null) {
            this.utilisateurRepository.save(utilisateur);
        }

    }
    public Utilisateur Lire(int id){
        Optional<Utilisateur> optionalutilsateur = this.utilisateurRepository.findById(id);
        if (optionalutilsateur.isPresent()) {
            return optionalutilsateur.get();
        }
        return null;
    }
    public List<Utilisateur> chercher(int id){
        Optional<Rolee> rolee = this.roleeRepository.findById(id);
        List<Utilisateur> optionalutilsateur = this.utilisateurRepository.findByRolee(rolee);
        
            return optionalutilsateur;
       
    }
    public void modifier(int id, Utilisateur utilisateur){
        Utilisateur utilisateurdb = this.Lire(id);
        if (utilisateurdb.getId() == utilisateur.getId()) {
            utilisateurdb.setEmail(utilisateur.getEmail());
            utilisateurdb.setNom(utilisateur.getNom());
            this.utilisateurRepository.save(utilisateurdb);  
        }

    }
    public List<Utilisateur> rechercher(){

        return this.utilisateurRepository.findAll();
    }
    @Override
    public Utilisateur loadUserByUsername(String username) throws UsernameNotFoundException {
        return this.utilisateurRepository
        .findByEmail(username)
        .orElseThrow(()-> new UsernameNotFoundException("Aucun utilisateur ne correspond à cet identifiant"));
        
    }


}
