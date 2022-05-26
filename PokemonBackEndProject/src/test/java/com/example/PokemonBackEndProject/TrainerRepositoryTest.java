package com.example.PokemonBackEndProject;

import com.example.PokemonBackEndProject.controller.TrainerController;
import com.example.PokemonBackEndProject.model.Trainer;
import com.example.PokemonBackEndProject.repository.TrainerRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
@SpringBootTest
public class TrainerRepositoryTest {

    @Autowired
    TrainerRepository trainerRepository;

    @Autowired
    TrainerController trainerController;

    @Test
    void contextLoads() {
    }


    // QUERY - Find trainers by town
    @Test
    public void canFindTrainerInLondon() {
        List<Trainer> found = trainerRepository.findByTown("London");
        assertThat(found.size()).isEqualTo(1);
    }

    @Test
    public void canFindTrainerById2() {
        Optional<Trainer> found = trainerRepository.findById(2L);
        assertThat(found.get().getID().equals(2));
    }
}
