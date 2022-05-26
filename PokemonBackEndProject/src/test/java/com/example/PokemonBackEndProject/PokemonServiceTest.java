package com.example.PokemonBackEndProject;

import com.example.PokemonBackEndProject.Service.PokemonService;
import com.example.PokemonBackEndProject.model.Pokemon;
import com.example.PokemonBackEndProject.repository.PokemonRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class PokemonServiceTest {
    @Autowired
    PokemonService pokemonService;

    @Autowired
    PokemonRepository pokemonRepository;


    @Test
    void contextLoads() {
    }
//    This tests the updatePokemon method in Pokemon Service
            @Test
             public void canUpdatePokemon(){
            ///given
            //when
            pokemonService.updatePokemon(1l, "Butterfry", "Flying",400 );
            Optional<Pokemon> pokemon = pokemonRepository.findById(1l);

            //then
            assertEquals(pokemon.get().getRating(), 400);
            assertEquals(pokemon.get().getName(), "Butterfry");
            assertEquals(pokemon.get().getType(), "Flying");

        }
    }


