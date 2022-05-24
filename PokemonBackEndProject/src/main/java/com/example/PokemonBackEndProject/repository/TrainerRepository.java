package com.example.PokemonBackEndProject.repository;

import com.example.PokemonBackEndProject.model.Trainer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TrainerRepository extends JpaRepository<Trainer, Long> {

    @Query(value = "SELECT * FROM trainer WHERE town = ?1", nativeQuery = true)
    List<Trainer> findByTown(String town);
}
