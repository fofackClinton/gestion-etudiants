package com.example.universiter.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.universiter.entities.Etudiant;
import com.example.universiter.service.EtudiantService;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;



import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;



@RestController
@RequestMapping(path = "etudiant")


public class EtudiantController {
    private EtudiantService etudiantService;

    public EtudiantController(EtudiantService etudiantService) {
        this.etudiantService = etudiantService;
    }
    @GetMapping(produces = APPLICATION_JSON_VALUE)
    public Iterable <Etudiant> listeEtud()
    {
        return this.etudiantService.lister();
    }
    @PostMapping(path = "inscrire")
    public void inscription(@RequestBody Etudiant etudiant) {
        this.etudiantService.Crerr(etudiant);
    }
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(consumes = APPLICATION_JSON_VALUE)
    public void creer(@RequestBody Etudiant etudiant)
    {
        this.etudiantService.creer(etudiant);
    }

    @GetMapping(path= "{id}", produces = APPLICATION_JSON_VALUE)
    public Etudiant lire(@PathVariable int id){
        return this.etudiantService.Lire(id);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping(path = "{id}", consumes = APPLICATION_JSON_VALUE)
    public void modifier(@PathVariable int id, @RequestBody Etudiant etudiant) {
        this.etudiantService.modifier(id, etudiant);
    }
    @ResponseStatus(HttpStatus.ACCEPTED)
    @DeleteMapping(path = "{id}")
    public void supprimer(@PathVariable int id){
        this.etudiantService.supprimer(id);
    }
}
