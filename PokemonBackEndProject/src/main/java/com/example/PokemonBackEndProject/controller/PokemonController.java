package com.example.PokemonBackEndProject.controller;

import com.example.PokemonBackEndProject.model.Pokemon;
import com.example.PokemonBackEndProject.repository.PokemonRepository;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class PokemonController {

    @Autowired
    private final PokemonRepository pokemonRepository;
    
    public PokemonController(PokemonRepository pokemonRepository){
        this.pokemonRepository = pokemonRepository;
    }

    // CREATE - POST
//    This Post and Get do not need an /{id} (because you do not have an id for it/ because you are trying to view all
//    of them)
    @PostMapping("/pokemon")
//    This creates a new Pokemon object (assigns it to an existing trainer)
    public ResponseEntity<List<Pokemon>> postPokemon(@RequestBody Pokemon pokemon) {
        pokemonRepository.save(pokemon);
        return new ResponseEntity<>(pokemonRepository.findAll(), HttpStatus.CREATED);
    }

    // READ - GET
    @GetMapping("/pokemon")
    public ResponseEntity<List<Pokemon>> getAllPokemon() {
        return new ResponseEntity<>(pokemonRepository.findAll(), HttpStatus.OK);
    }

    // UPDATE - PUT
//    @PutMapping("/pokemon/{name}")
//    public ResponseEntity<Pokemon> updatePokemon(@PathVariable(value = "name") String pokemonName), @Valid
//    @RequestBody Pokemon pokemon) throws ResourceNotFoundException {
//    Pokemon pokemon = pokemonRepository.findByName(pokemon.getName())
//            .orElseThrow(() -> new Exception ("Pokemon not found for this name :: " + pokemon.getName());
//
//    pokemon.setId(pokemon.getId());
//    pokemon.setName(pokemon.getName());
//    pokemon.setType(pokemon.getType());
//    pokemon.setGeneration(pokemon.getGeneration());
//    pokemon.setTrainer(pokemon.getTrainer());
//
//    final Pokemon updatedPokemon = pokemonRepository.save(pokemon);
//    return ResponseEntity.ok(updatedPokemon);
    }

    // DELETE
//  @DeleteMapping("/pokemon/{name}")
//  public Map<String, Boolean> deletePokemon(@PathVariable(value = "name") String pokemonName)
//      throws ResourceNotFoundException {
//          Pokemon pokemon = pokemonRepository.findByName(pokemonName)
//              .orElseThrow(() -> new ResourceNotFoundException("Pokemon not found for this id
