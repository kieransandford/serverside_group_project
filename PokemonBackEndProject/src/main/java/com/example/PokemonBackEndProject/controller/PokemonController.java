package com.example.PokemonBackEndProject.controller;

import com.example.PokemonBackEndProject.model.Pokemon;
import com.example.PokemonBackEndProject.repository.PokemonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("pokemon")
public class PokemonController {
    
    @Autowired
    PokemonRepository pokemonRepository;

    // CREATE - POST
    @PostMapping
    public ResponseEntity<List<Pokemon>> postPokemon(@RequestBody Pokemon pokemon) {
        pokemonRepository.save(pokemon);
        return new ResponseEntity<>(pokemonRepository.findAll(), HttpStatus.CREATED);
    }

    // READ - GET
    @GetMapping
    public ResponseEntity<List<Pokemon>> getAllPokemon(@RequestBody Pokemon pokemon) {
        return new ResponseEntity<>(pokemonRepository.findAll(), HttpStatus.OK);
    }

    // UPDATE - PUT
    @PutMapping("/pokemon/{name}")
    public ResponseEntity

    // DELETE

    
}
