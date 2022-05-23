package com.example.PokemonBackEndProject;

import com.example.PokemonBackEndProject.model.Pokemon;
import com.example.PokemonBackEndProject.repository.PokemonRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.List;

@SpringBootTest
class PokemonBackEndProjectApplicationTests {

	@Autowired
	PokemonRepository pokemonRepository;

	@Test
	void contextLoads() {
	}

	@Test
	public void	canFindPokemonButterfree() {
		List<Pokemon> found = pokemonRepository.findByName("Butterfree");
		assertThat(found).isEqualTo("Butterfree");
	}

}
