package com.example.PokemonBackEndProject.repository;

import com.example.PokemonBackEndProject.model.Pokemon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PokemonRepository extends JpaRepository<Pokemon, Long> {
        //Get all Pokemon of a specific type
//    @Query(value = "SELECT * FROM POKEMON WHERE TYPE = 'Normal' ", nativeQuery = true)
//    List<Pokemon> findAllOfType();

    List<Pokemon> findByName(String name);

    List<Pokemon> findByType(String type);
}
