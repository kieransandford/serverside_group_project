package com.example.PokemonBackEndProject;

import com.example.PokemonBackEndProject.GenerationList;
import com.example.PokemonBackEndProject.model.Business;
import com.example.PokemonBackEndProject.model.Pokemon;
import com.example.PokemonBackEndProject.model.Trainer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BusinessTwoTest {
    Trainer trainer;
    Pokemon pokemon;
    Pokemon pokemon1;
    Pokemon pokemon2;
    Business business;

    @BeforeEach
    public void setUp(){
        trainer = new Trainer(1l, "George", 45, "Leeds", 72);
        pokemon = new Pokemon(1l, "Jigglypuff", "Electric", GenerationList.Alola, 300,
                20, trainer);
        pokemon1 = new Pokemon(2l, "Testiffy", "Normal", GenerationList.Kalos, 350,
                25, trainer);
        pokemon2 = new Pokemon(3l, "Testtoofy", "Electric", GenerationList.Alola, 430,
                30, trainer);
        business = new Business("Pokebusiness", 0);
        business.addPoke(pokemon);
        business.addPoke(pokemon1);

    }
//  Tests buyPokemon() in the Trainer class
    @Test
    public void actuallyBuyPokemon() {
//        given trainer and pokemon
//        when
        trainer.buyPokemon(pokemon);
//        then
        assertTrue(trainer.getPokemons().contains(pokemon));
    }
//    This test is for the Business class method calcPokeValue()
    @Test
    public void canCalculatePokemonValue(){
//        given business has added pokemon and pokemon1.
//        when
        business.calcPokeValue();
//        then
        assertEquals(45, business.calcPokeValue());
    }
    
    
    
}
