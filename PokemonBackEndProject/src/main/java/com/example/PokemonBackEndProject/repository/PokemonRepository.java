package com.example.PokemonBackEndProject.repository;

import com.example.PokemonBackEndProject.model.Pokemon;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PokemonRepository extends JpaRepository<Pokemon, Long> {

    List<Pokemon> findByName(String name);

    List<Pokemon> findByType(String type);

    Optional<Pokemon> findById(Long id);
}
