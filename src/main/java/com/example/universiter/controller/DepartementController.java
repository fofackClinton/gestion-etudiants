package com.example.universiter.controller;
import org.springframework.web.bind.annotation.RestController;

import com.example.universiter.entities.Departement;

import com.example.universiter.service.DepartementService;

import lombok.AllArgsConstructor;

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

@AllArgsConstructor
@RestController
@RequestMapping(path = "departement")
public class DepartementController {
    private DepartementService departementService;

    @GetMapping(produces = APPLICATION_JSON_VALUE)
    public Iterable <Departement> listeEtud()
    {
        return this.departementService.lister();
    }
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(consumes = APPLICATION_JSON_VALUE)
    public void creer(@RequestBody Departement departement)
    {
        this.departementService.creer(departement);
    }

    @GetMapping(path= "{id}", produces = APPLICATION_JSON_VALUE)
    public Departement lire(@PathVariable int id){
        return this.departementService.Lire(id);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping(path = "{id}", consumes = APPLICATION_JSON_VALUE)
    public void modifier(@PathVariable int id, @RequestBody Departement departement) {
        this.departementService.modifier(id, departement);
    }
    @ResponseStatus(HttpStatus.ACCEPTED)
    @DeleteMapping(path = "{id}")
    public void supprimer(@PathVariable int id){
        this.departementService.supprimer(id);
    }

}
