package com.example.PokemonBackEndProject;

import com.example.PokemonBackEndProject.model.Pokemon;
import com.example.PokemonBackEndProject.repository.PokemonRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
@SpringBootTest
public class PokemonRepositoryTest {

    @Autowired
    private PokemonRepository pokemonRepository;

    @Test
    void contextLoads() {
    }

    @Test
    public void	canFindPokemonButterfree() {
        Optional<Pokemon> found = pokemonRepository.findByName("Butterfree");
        assertEquals(found.get().getName(), "Butterfree");
    }
    //	Test findByNameLike method in PokemonRepository
    @Test
    public void canFindByNameLike(){
//		given pokemonRepository
//		when:
//		we call the method, it returns a list of Pokemon with similar names to input.
        List<Pokemon> result = pokemonRepository.findByNameLike("ot");
//		then:
//		there should be 2 elements in the list as one Pokemon has a name that contain "ot".
        assertEquals(result.size(), 2);

    }



}
