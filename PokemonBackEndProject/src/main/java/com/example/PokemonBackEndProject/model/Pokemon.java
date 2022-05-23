package com.example.PokemonBackEndProject.model;

import javax.persistence.*;

//This maps it to a table
@Entity
public class Pokemon {
//    Auto generates the id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String type;
    private String generation;
    @ManyToOne
    private Trainer trainer;
//    no arg constructor
    public Pokemon(){
    }

//    arg constructor
    public Pokemon(Long id, String name, String type, String generation, Trainer trainer){
        this.id = id;
        this.name = name;
        this.type = type;
        this.generation = generation;
        this.trainer = trainer;
    }

//    getters and setters

    public Long getId() {
        return this.id;
    }
    public void setId(Long id){
        this.id = id;
    }
    public String getName(){
        return this.name;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getType() {
        return this.type;
    }
    public void setType(String type){
        this.type = type;
    }
    public String getGeneration() {
        return this.generation;
    }
    public void setGeneration(String generation){
        this.generation = generation;
    }
    public Trainer getTrainer(){
        return trainer;
    }
    public void setTrainer(Trainer trainer){
        this.trainer = trainer;
    }

}
