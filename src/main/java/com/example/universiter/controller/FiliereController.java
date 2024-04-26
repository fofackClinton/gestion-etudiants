package com.example.universiter.controller;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.example.universiter.entities.Filiere;

import com.example.universiter.service.FiliereService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@CrossOrigin
@RestController
public class FiliereController {
    private FiliereService filiereService;

    @GetMapping(path = "filiere", produces = APPLICATION_JSON_VALUE)
    public Iterable <Filiere> listeEtud()
    {
        return this.filiereService.lister();
    }
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(path = "filiere", consumes = APPLICATION_JSON_VALUE)
    public void creer(@RequestBody Filiere filiere)
    {
        this.filiereService.creer(filiere);
    }

    @GetMapping(path= "filiere/{id}", produces = APPLICATION_JSON_VALUE)
    public Filiere lire(@PathVariable int id){
        return this.filiereService.Lire(id);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping(path = "filiere/{id}", consumes = APPLICATION_JSON_VALUE)
    public void modifier(@PathVariable int id, @RequestBody Filiere filiere) {
        this.filiereService.modifier(id, filiere);
    }
    @ResponseStatus(HttpStatus.ACCEPTED)
    @DeleteMapping(path = "filiere/{id}")
    public void supprimer(@PathVariable int id){
        this.filiereService.supprimer(id);
    }
}
