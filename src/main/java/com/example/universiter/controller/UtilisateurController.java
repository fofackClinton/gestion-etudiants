package com.example.universiter.controller;


import org.springframework.web.bind.annotation.*;

import com.example.universiter.Dto.AuthenticationDTO;
import com.example.universiter.entities.Utilisateur;
import com.example.universiter.securite.JwtService;
import com.example.universiter.service.UtilisateurService;


import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import lombok.AllArgsConstructor;
// import lombok.extern.log4j.Log4j2;

import java.util.List;
import java.util.Map;


@RestController
@CrossOrigin
// @Log4j2
@AllArgsConstructor
public class UtilisateurController {
    private JwtService jwtService;
    private UtilisateurService utilisateurService;
    private AuthenticationManager authenticationManager;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(path = "utilisateur", consumes = APPLICATION_JSON_VALUE)
    public void inscription(@RequestBody Utilisateur utilisateur)
    {
        this.utilisateurService.inscription(utilisateur);
    }
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(path = "responsable", consumes = APPLICATION_JSON_VALUE)
    public void responsable(@RequestBody Utilisateur utilisateur)
    {
        this.utilisateurService.inscription(utilisateur);
    }

    @GetMapping(path = "utilisateur", produces = APPLICATION_JSON_VALUE)
    public List<Utilisateur> listeClient(){
        return this.utilisateurService.rechercher();
    }
    /**
     * @param rolee
     * @return list off user who have this rolee
     */
    @GetMapping(path = "utilisateur/rolee/{id}", produces = APPLICATION_JSON_VALUE)
    public List<Utilisateur> chercher(@PathVariable int id){
        return this.utilisateurService.chercher(id);
    }

    @GetMapping(path= "utilisateur/{id}", produces = APPLICATION_JSON_VALUE)
    public Utilisateur lire(@PathVariable int id){
        return this.utilisateurService.Lire(id);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping(path = "utilisateur/{id}", consumes = APPLICATION_JSON_VALUE)
    public void modifier(@PathVariable int id, @RequestBody Utilisateur utilisateur) {
        this.utilisateurService.modifier(id, utilisateur);
    }
    @PostMapping(path = "/connexion")
    public Map<String, String> connexion(@RequestBody AuthenticationDTO authenticationDTO)
    {
       final Authentication authenticate = authenticationManager
        .authenticate
        (
            new UsernamePasswordAuthenticationToken
            (authenticationDTO.username(), authenticationDTO.password())
        );
        if (authenticate.isAuthenticated()) {
          return  this.jwtService.generate(authenticationDTO.username());
        }
        // log.info("resultat{}", authenticate.isAuthenticated());
        return null;
    }
}
