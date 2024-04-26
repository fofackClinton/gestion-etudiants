package com.example.universiter.controller;
import org.springframework.web.bind.annotation.*;

import com.example.universiter.entities.Departement;

import com.example.universiter.service.DepartementService;

import lombok.AllArgsConstructor;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import org.springframework.http.HttpStatus;

@AllArgsConstructor
@CrossOrigin
@RestController
public class DepartementController {
    private DepartementService departementService;

    @GetMapping(path = "departement", produces = APPLICATION_JSON_VALUE)
    public Iterable <Departement> listeEtud()
    {
        return this.departementService.lister();
    }
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(path = "departement", consumes = APPLICATION_JSON_VALUE)
    public void creer(@RequestBody Departement departement)
    {
        this.departementService.creer(departement);
    }

    @GetMapping(path= "departement/{id}", produces = APPLICATION_JSON_VALUE)
    public Departement lire(@PathVariable int id){
        return this.departementService.Lire(id);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping(path = "departement/{id}", consumes = APPLICATION_JSON_VALUE)
    public void modifier(@PathVariable int id, @RequestBody Departement departement) {
        this.departementService.modifier(id, departement);
    }
    @ResponseStatus(HttpStatus.ACCEPTED)
    @DeleteMapping(path = "departement/{id}")
    public void supprimer(@PathVariable int id){
        this.departementService.supprimer(id);
    }

}
