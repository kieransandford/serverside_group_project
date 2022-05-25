package com.example.PokemonBackEndProject.repository;

import com.example.PokemonBackEndProject.model.Pokemon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface PokemonRepository extends JpaRepository<Pokemon, Long> {

    List<Pokemon> findByName(String name);

    List<Pokemon> findByType(String type);

    //  The random Pokemon method uses this method to find a Pokemon at a random id index
    @Query(value = "SELECT * FROM Pokemon WHERE id = ?", nativeQuery = true)
    Optional<Pokemon> findById(Long id);

}
