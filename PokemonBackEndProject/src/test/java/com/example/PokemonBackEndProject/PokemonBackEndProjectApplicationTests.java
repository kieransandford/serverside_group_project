package com.example.PokemonBackEndProject;

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
	public void canChangeNameAndType() {
		//Given - name
		List<Pokemon> name = pokemonRepository.findByName("Skorupi");
		//When - put method changes name
		if (name.equals("Drapion")) {

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

	// QUERY - Find trainers by town
	@Test
	public void canFindTrainerInLondon() {
		List<Trainer> found = trainerRepository.findByTown("London");
		assertThat(found.size()).isEqualTo(1);
	}

//	Test findByNameLike method in PokemonRepository
	@Test
	public void canFindByNameLike(){
//		given pokemonRepository
//		when:
//		we call the method, it returns a list of Pokemon with similar names to input.
		List<Pokemon> result = pokemonRepository.findByNameLike("ot");
//		then:
//		there should be 2 elements in the list as two Pokemon have names that contain "ot".
		assertEquals(result.size(), 2);

	}

}
