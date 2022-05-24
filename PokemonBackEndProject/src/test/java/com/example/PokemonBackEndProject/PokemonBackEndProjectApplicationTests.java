package com.example.PokemonBackEndProject;

import com.example.PokemonBackEndProject.Service.TrainerService;
import com.example.PokemonBackEndProject.model.Pokemon;
import com.example.PokemonBackEndProject.model.Trainer;
import com.example.PokemonBackEndProject.repository.PokemonRepository;
import com.example.PokemonBackEndProject.repository.TrainerRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

@SpringBootTest
class PokemonBackEndProjectApplicationTests {

	@Autowired
	private PokemonRepository pokemonRepository;

	@Autowired
	private TrainerRepository trainerRepository;

	@Test
	void contextLoads() {
	}

	@Test
	public void	canFindPokemonButterfree() {
		List<Pokemon> found = pokemonRepository.findByName("Butterfree");
		assertThat(found).isEqualTo("Butterfree");
	}


	@Test
	public void canFindTrainerInLondon() {
		List<Trainer> found = trainerRepository.findByTown("London");
		assertThat(found.size()).isEqualTo(1);
	}

}
