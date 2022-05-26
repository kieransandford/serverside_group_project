package com.example.PokemonBackEndProject.repository;

import com.example.PokemonBackEndProject.model.Pokemon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface PokemonRepository extends JpaRepository<Pokemon, Long> {
        //Get all Pokemon of a specific type
//    @Query(value = "SELECT * FROM POKEMON WHERE TYPE = 'Normal' ", nativeQuery = true)
//    List<Pokemon> findAllOfType();

    Optional<Pokemon> findByName(String name);

    List<Pokemon> findByType(String type);

    //  The random Pokemon method uses this method to find a Pokemon at a random id index
    @Query(value = "SELECT * FROM Pokemon WHERE id = ?1", nativeQuery = true)
    Optional<Pokemon> findById(Long id);
    List<Pokemon> findByOrderByRatingDesc();

    @Query(value = "SELECT * FROM Pokemon WHERE name LIKE %:name%", nativeQuery = true)
    List<Pokemon> findByNameLike(@Param("name") String name);

}
