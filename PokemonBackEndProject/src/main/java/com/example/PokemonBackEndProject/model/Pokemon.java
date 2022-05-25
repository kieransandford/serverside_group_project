package com.example.PokemonBackEndProject.model;

import com.example.PokemonBackEndProject.GenerationList;

import javax.persistence.*;

//This maps it to a table
@Entity
public class Pokemon {
//    Auto generates the id
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Pokemon_sequence")
    @SequenceGenerator(name = "Pokemon_sequence", allocationSize = 1, initialValue = 21)
    private Long id;
    @Column (nullable = false)
    private String name;
    private String type;
    @Enumerated(EnumType.STRING)
    private GenerationList generation;

    private double price;

    private int rating;
    @ManyToOne
//    @JoinColumn (name = "trainer_id", nullable = false)
    private Trainer trainer;
//    no arg constructor
    public Pokemon(){
    }

//    arg constructor
    public Pokemon(Long id, String name, String type, GenerationList generation, int rating, double price, Trainer trainer){
        this.id = id;
        this.name = name;
        this.type = type;
        this.generation = generation;
        this.rating = rating;
        this.price = price;
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
    public GenerationList getGeneration() {
        return this.generation;
    }
    public void setGeneration(GenerationList generation){
        this.generation = generation;
    }
    public Trainer getTrainer(){
        return trainer;
    }
    public void setTrainer(Trainer trainer){
        this.trainer = trainer;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}
