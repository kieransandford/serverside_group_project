package com.example.PokemonBackEndProject.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Trainer {
    // Setting types and objects
//    This auto generates the ID type
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Trainer_sequence")
    @SequenceGenerator(name = "Trainer_sequence", allocationSize = 1, initialValue = 5)
    private Long id;
    private String name;
    private int age;
    private String town;

    private double wallet;



    // links the relationship from trainer to many pokemons that the trainer could own
    @OneToMany(mappedBy = "trainer", cascade = CascadeType.ALL) //CascadeType consists of operation PERSIST, MERGE, REMOVE, REFRESH and DETACH
    @JsonIgnoreProperties(value = {"trainer"}) //Required to ensure only the trainer and its pokemons are displayed, rather than looping through both tables (effectively break point)
    private List<Pokemon> pokemons; //listing the pokemon in the database that can be linked to the trainer

    public Trainer(Long id, String name, int age, String town, double wallet){
        this.id = id;
        this.name = name;
        this.age = age;
        this.town = town;
        this.wallet = wallet;
        this.pokemons = new ArrayList<>();
        }


    // no arg constructor

    public Trainer(){
    }

// unique methods
    public boolean canBuy(Pokemon pokemon){
        if(pokemon.getPrice() <= this.wallet){
            return true;
        }
        return false;
    }

    public void buyPokemon(Pokemon pokemon){
        this.wallet -= pokemon.getPrice();
        this.pokemons.add(pokemon);
    }

    public int getPokemonCount(){
        return this.pokemons.size();
    }

    // getters and setters

    public Long getID(){
        return id;
    }
    public void setId(Long id){
        this.id = id;
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    public int getAge(){
        return age;
    }
    public void setAge(int age){
        this.age = age;
    }
    public String getTown(){
        return town;
    }
    public void setTown(String town){
        this.town = town;
    }
    public List<Pokemon> getPokemons() {
        return this.pokemons;
    }
    public void setPokemons (List < Pokemon > pokemons) {
        this.pokemons = pokemons;
        }

        public double getWallet(){
        return wallet;
        }
        public void setWallet(double wallet){
        this.wallet = wallet;
        }
    }
