package com.example.universiter.controller;
import com.example.universiter.Dto.ClasseDto;
import org.springframework.http.HttpStatus;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.universiter.entities.Classe;
import com.example.universiter.service.ClasseService;

import lombok.AllArgsConstructor;

import java.util.List;
import java.util.stream.Stream;

@AllArgsConstructor
@CrossOrigin(origins = " http://localhost:4200 ")
@RestController
public class ClasseController {
    private ClasseService classeService;

    @GetMapping(path = "classe", produces = APPLICATION_JSON_VALUE)
        public Stream<ClasseDto> getAll() {return this.classeService.lister();}

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(path = "classe", consumes = APPLICATION_JSON_VALUE)
    public void creer(@RequestBody Classe classe)
    {
        this.classeService.creer(classe);
    }

    @GetMapping(path= "classe/{id}", produces = APPLICATION_JSON_VALUE)
    public Classe lire(@PathVariable int id){
        return this.classeService.Lire(id);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping(path = "classe/{id}", consumes = APPLICATION_JSON_VALUE)
    public void modifier(@PathVariable int id, @RequestBody Classe classe) {
        this.classeService.modifier(id, classe);
    }
    @ResponseStatus(HttpStatus.ACCEPTED)
    @DeleteMapping(path = "classe/{id}")
    public void supprimer(@PathVariable int id){
        this.classeService.supprimer(id);
    }

}
