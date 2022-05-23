package com.example.PokemonBackEndProject.repository;

import com.example.PokemonBackEndProject.model.Trainer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrainerRepository extends JpaRepository<Trainer, Long> {
}
