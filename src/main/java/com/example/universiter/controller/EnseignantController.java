package com.example.universiter.controller;
import org.springframework.web.bind.annotation.RestController;

import com.example.universiter.entities.Enseignant;
import com.example.universiter.service.EnseignantService;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import java.util.List;


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
@RequestMapping(path = "enseignant")
public class EnseignantController {
    
    private EnseignantService enseignantService;

    public EnseignantController(EnseignantService enseignantService) {
        this.enseignantService = enseignantService;
    }
    @GetMapping(produces = APPLICATION_JSON_VALUE)
    public List <Enseignant> listeEtud()
    {
        return this.enseignantService.lister();
    }
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(consumes = APPLICATION_JSON_VALUE)
    public void creer(@RequestBody Enseignant enseignant)
    {
        this.enseignantService.creer( enseignant);
    }

    @GetMapping(path= "{id}", produces = APPLICATION_JSON_VALUE)
    public  Enseignant lire(@PathVariable int id){
        return this.enseignantService.Lire(id);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping(path = "{id}", consumes = APPLICATION_JSON_VALUE)
    public void modifier(@PathVariable int id, @RequestBody  Enseignant  enseignant) {
        this.enseignantService.modifier(id,  enseignant);
    }
    @ResponseStatus(HttpStatus.ACCEPTED)
    @DeleteMapping(path = "{id}")
    public void supprimer(@PathVariable int id){
        this.enseignantService.supprimer(id);
    }

}
