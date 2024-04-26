package com.example.universiter.controller;

import org.springframework.web.bind.annotation.*;

import com.example.universiter.entities.Etudiant;
import com.example.universiter.service.EtudiantService;

import lombok.AllArgsConstructor;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;



import org.springframework.http.HttpStatus;


@AllArgsConstructor
@CrossOrigin
@RestController


public class EtudiantController {
    private EtudiantService etudiantService;

    @GetMapping(path = "etudiant", produces = APPLICATION_JSON_VALUE)
    public Iterable <Etudiant> listeEtud()
    {
        return this.etudiantService.lister();
    }
    @PostMapping(path = "inscrire")
    public void inscription(@RequestBody Etudiant etudiant) {
        this.etudiantService.Crerr(etudiant);
    }
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(path = "etudiant", consumes = APPLICATION_JSON_VALUE)
    public void creer(@RequestBody Etudiant etudiant)
    {
        this.etudiantService.creer(etudiant);
    }

    @GetMapping(path= "etudiant/{id}", produces = APPLICATION_JSON_VALUE)
    public Etudiant lire(@PathVariable int id){
        return this.etudiantService.Lire(id);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping(path = "etudiant/{id}", consumes = APPLICATION_JSON_VALUE)
    public void modifier(@PathVariable int id, @RequestBody Etudiant etudiant) {
        this.etudiantService.modifier(id, etudiant);
    }
    @ResponseStatus(HttpStatus.ACCEPTED)
    @DeleteMapping(path = "etudiant/{id}")
    public void supprimer(@PathVariable int id){
        this.etudiantService.supprimer(id);
    }
}
