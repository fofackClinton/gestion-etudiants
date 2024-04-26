package com.example.universiter.controller;
import org.springframework.web.bind.annotation.*;

import com.example.universiter.entities.Enseignant;
import com.example.universiter.service.EnseignantService;

import lombok.AllArgsConstructor;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import java.util.List;


import org.springframework.http.HttpStatus;


@AllArgsConstructor
@CrossOrigin
@RestController
public class EnseignantController {
    
    private EnseignantService enseignantService;

    @GetMapping(path = "enseignant", produces = APPLICATION_JSON_VALUE)
    public List <Enseignant> listeEtud()
    {
        return this.enseignantService.lister();
    }
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(path = "enseignant", consumes = APPLICATION_JSON_VALUE)
    public void creer(@RequestBody Enseignant enseignant)
    {
        this.enseignantService.creer( enseignant);
    }

    @GetMapping(path= "enseignant/{id}", produces = APPLICATION_JSON_VALUE)
    public  Enseignant lire(@PathVariable int id){
        return this.enseignantService.Lire(id);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping(path = "enseignant/{id}", consumes = APPLICATION_JSON_VALUE)
    public void modifier(@PathVariable int id, @RequestBody  Enseignant  enseignant) {
        this.enseignantService.modifier(id,  enseignant);
    }
    @ResponseStatus(HttpStatus.ACCEPTED)
    @DeleteMapping(path = "enseignant/{id}")
    public void supprimer(@PathVariable int id){
        this.enseignantService.supprimer(id);
    }

}
