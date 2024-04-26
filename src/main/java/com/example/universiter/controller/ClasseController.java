package com.example.universiter.controller;
import org.springframework.web.bind.annotation.RestController;

import com.example.universiter.entities.Classe;

import com.example.universiter.service.ClasseService;

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
@RequestMapping(path = "classe")
public class ClasseController {
    private ClasseService classeService;

    public ClasseController(ClasseService classeService) {
        this.classeService = classeService;
    }
    @GetMapping(produces = APPLICATION_JSON_VALUE)
    public Iterable <Classe> listeEtud()
    {
        return this.classeService.lister();
    }
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(consumes = APPLICATION_JSON_VALUE)
    public void creer(@RequestBody Classe classe)
    {
        this.classeService.creer(classe);
    }

    @GetMapping(path= "{id}", produces = APPLICATION_JSON_VALUE)
    public Classe lire(@PathVariable int id){
        return this.classeService.Lire(id);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping(path = "{id}", consumes = APPLICATION_JSON_VALUE)
    public void modifier(@PathVariable int id, @RequestBody Classe classe) {
        this.classeService.modifier(id, classe);
    }
    @ResponseStatus(HttpStatus.ACCEPTED)
    @DeleteMapping(path = "{id}")
    public void supprimer(@PathVariable int id){
        this.classeService.supprimer(id);
    }

}
