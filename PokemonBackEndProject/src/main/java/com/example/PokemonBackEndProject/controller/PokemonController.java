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
import java.util.Optional;

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

    // READ - GET - gets all Pokemon
    @GetMapping("/pokemon")
    public ResponseEntity<List<Pokemon>> getAllPokemon() {
        return new ResponseEntity<>(pokemonRepository.findAll(), HttpStatus.OK);
    }
//  Get a Pokemon by id number(long).
    @GetMapping("/pokemon/id")
    public ResponseEntity<Optional<Pokemon>> getPokemonById(@RequestParam(required = false) Long id){
        Optional<Pokemon> chosen = pokemonRepository.findById(id);
        return ResponseEntity
                .ok()
                .body(chosen);
    }

    // UPDATE - PUT
    @PutMapping("/pokemon/{id}")
// Change the name and type of the pokemon
// These are the parameters for the method (PathVariable to String )
    public void updatePokemon(
            @PathVariable("id") Long pokemonId,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String type,
            @RequestParam(required = false) int rating){
        pokemonService.updatePokemon(pokemonId, name, type, rating);
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
    // GET MAP FOR RANKING POKEMON
    @GetMapping ("/pokemon/rating")
    public ResponseEntity<List<Pokemon>> findByOrderByRatingDesc() {
         return new ResponseEntity<>(pokemonRepository.findByOrderByRatingDesc(), HttpStatus.OK);
    }

    //    Generate a random Pokemon by id (Pokemon of the day)
    @GetMapping("pokemon/random")
    public ResponseEntity<Optional<Pokemon>> getRandomPokemon(){
        Long random = Long.valueOf(0);
        boolean loop = true;
        while(loop) {
//            Generate a random long between 0 and the number of pokemon in the database (rounded).
//        This could equal to 0 but there is no Pokemon at index 0, so if that is the case, the loop continues and another
//        random number is generated.
            random = Math.round((Math.random() * pokemonRepository.count()));
            if(random != 0){
//                If the number is not 0, then stop the loop because we've got our suitable number.
                loop = false;
            }
        }
        Optional<Pokemon> randomPoke = pokemonRepository.findById(random);
        return ResponseEntity
                .ok()
                .body(randomPoke);
    }
//      Get Pokemon when you've forgotten the exact name
    @GetMapping("pokemon/similar")
    public ResponseEntity<List<Pokemon>> findByNameLike(@RequestParam(required = false, name = "name") String name){
        if (name != null){
            return new ResponseEntity<>(pokemonRepository.findByNameLike(name), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(pokemonRepository.findAll(), HttpStatus.OK);
        }
    }
}
