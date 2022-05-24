package com.example.PokemonBackEndProject.controller;

import com.example.PokemonBackEndProject.Service.PokemonService;
import com.example.PokemonBackEndProject.model.Pokemon;
import com.example.PokemonBackEndProject.repository.PokemonRepository;
import org.apache.catalina.User;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@RestController
public class PokemonController {

    @Autowired
    private final PokemonRepository pokemonRepository;
    private PokemonService pokemonService;

    public PokemonController(PokemonRepository pokemonRepository, PokemonService pokemonService) {
        this.pokemonRepository = pokemonRepository;
        this.pokemonService = pokemonService;
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
    @PutMapping("/pokemon/{id}")
// Change the name and type of the pokemon
// These are the parameters for the method (PathVariable to String )
    public void updatePokemon(
            @PathVariable("id") Long pokemonId,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String type) {
        pokemonService.updatePokemon(pokemonId, name, type);
    }

    @DeleteMapping("/pokemon/{id}")
    public void deletePokemon(@PathVariable(value = "id") Long pokemonId) {
        pokemonService.deletePokemon(pokemonId);
    }

    //  This finds all Pokemon of a specific type
    @GetMapping("/pokemon/{type}")
    public ResponseEntity<List<Pokemon>> getAllPokemon(@RequestParam(required = false) String type) {
        List<Pokemon> pokemons = pokemonRepository.findAll();
        List<Pokemon> pokemonSpecificType =
                pokemons.stream()
                        .filter(p -> p.getType().equals(type))
                        .toList();
        return ResponseEntity
                .ok()
                .body(pokemonSpecificType);
    }
}
