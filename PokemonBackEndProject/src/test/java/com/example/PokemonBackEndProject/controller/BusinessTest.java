package com.example.PokemonBackEndProject.controller;

import com.example.PokemonBackEndProject.GenerationList;
import com.example.PokemonBackEndProject.model.Pokemon;
import com.example.PokemonBackEndProject.model.Trainer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class BusinessTest {
    Trainer trainer;
    Pokemon pokemon;

    @BeforeEach
    public void setUp(){
        trainer = new Trainer(1l, "George", 45, "Leeds", 72);
        pokemon = new Pokemon(1l, "Jigglypuff", "Electric", GenerationList.Alola, 300,
                20, trainer);

    }
//  Tests buyPokemon() in the Trainer class
    @Test
    public void actuallybuyPokemon() {
//        given trainer and pokemon
//        when
        trainer.buyPokemon(pokemon);
//        then
        assertTrue(trainer.getPokemons().contains(pokemon));
    }


}
