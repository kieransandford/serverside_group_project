package com.example.PokemonBackEndProject.repository;

import com.example.PokemonBackEndProject.model.Pokemon;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PokemonRepository extends JpaRepository<Pokemon, Long> {
}
