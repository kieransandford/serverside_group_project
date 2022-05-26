package com.example.PokemonBackEndProject;

import com.example.PokemonBackEndProject.Service.PokemonService;
import com.example.PokemonBackEndProject.model.Pokemon;
import com.example.PokemonBackEndProject.repository.PokemonRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;

@SpringBootTest
public class PokemonServiceTest {
    @Autowired
    PokemonService pokemonService;

    @Autowired
    PokemonRepository pokemonRepository;

    @Test
    void contextLoads() {
    }


    @Test
    public void canChangeNameAndType() {
        //Given - name
        Optional<Pokemon> name = pokemonRepository.findByName("Skorupi");
        //When - put method changes name
        if (name.get().getName().equals("Drapion")) {

            //Then - return that name has changed
            assertThat(name).isEqualTo("Drapion");

            //Given - type
            List<Pokemon> type = pokemonRepository.findByType("Poison, Bug");
            //When - put method changes typing
            if (type.equals("Poison, Dark")) {
                //Then - return that it has changed its type
                assertThat(type).isEqualTo("Poison, Dark");
            }

        }
    }

}
