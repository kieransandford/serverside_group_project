package com.example.PokemonBackEndProject.repository;

import com.example.PokemonBackEndProject.model.Pokemon;
import com.example.PokemonBackEndProject.model.Trainer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TrainerRepository extends JpaRepository<Trainer, Long> {
//    Get all Pokemon of a specific type
    @Query(value = "SELECT * FROM POKEMON WHERE TYPE IS 'Normal' ", nativeQuery = true)
    List<Pokemon> findAllOfType();
}
