package com.example.universiter.controller;
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
import org.springframework.web.bind.annotation.RestController;

import com.example.universiter.entities.Filiere;

import com.example.universiter.service.FiliereService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping(path = "filiere")
public class FiliereController {
    private FiliereService filiereService;

    @GetMapping(produces = APPLICATION_JSON_VALUE)
    public Iterable <Filiere> listeEtud()
    {
        return this.filiereService.lister();
    }
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(consumes = APPLICATION_JSON_VALUE)
    public void creer(@RequestBody Filiere filiere)
    {
        this.filiereService.creer(filiere);
    }

    @GetMapping(path= "{id}", produces = APPLICATION_JSON_VALUE)
    public Filiere lire(@PathVariable int id){
        return this.filiereService.Lire(id);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping(path = "{id}", consumes = APPLICATION_JSON_VALUE)
    public void modifier(@PathVariable int id, @RequestBody Filiere filiere) {
        this.filiereService.modifier(id, filiere);
    }
    @ResponseStatus(HttpStatus.ACCEPTED)
    @DeleteMapping(path = "{id}")
    public void supprimer(@PathVariable int id){
        this.filiereService.supprimer(id);
    }


}
