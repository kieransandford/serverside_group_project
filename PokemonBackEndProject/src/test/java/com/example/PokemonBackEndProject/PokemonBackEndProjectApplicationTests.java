package com.example.PokemonBackEndProject;

import com.example.PokemonBackEndProject.model.Pokemon;
import com.example.PokemonBackEndProject.repository.PokemonRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.bind.annotation.RequestParam;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.List;
import java.util.Objects;

@SpringBootTest
class PokemonBackEndProjectApplicationTests {

	@Autowired
	PokemonRepository pokemonRepository;

	@Test
	void contextLoads() {
	}

	@Test
	public void canFindPokemonButterfree() {
		List<Pokemon> found = pokemonRepository.findByName("Butterfree");
		assertThat(found).isEqualTo("Butterfree");
	}

	@Test
	public void canChangeNameAndType() {
		List<Pokemon> name = pokemonRepository.findByName("Skorupi");
		if (name.equals("Drapion")) {
			assertThat(name).isEqualTo("Skorupi");
			List<Pokemon> type = pokemonRepository.findByType("Poison, Bug");
			if (type.equals("Poison, Dark")) {
				assertThat(type).isEqualTo("Poison, Bug");
			}

		}
	}
}
