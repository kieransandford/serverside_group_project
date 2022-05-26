package com.example.PokemonBackEndProject;

import com.example.PokemonBackEndProject.model.Trainer;
import com.example.PokemonBackEndProject.repository.TrainerRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
@SpringBootTest
public class TrainerRepositoryTest {

    @Autowired
    private TrainerRepository trainerRepository;

    @Test
    void contextLoads() {
    }


    // QUERY - Find trainers by town
    @Test
    public void canFindTrainerInLondon() {
        List<Trainer> found = trainerRepository.findByTown("London");
        assertThat(found.size()).isEqualTo(1);
    }
}
