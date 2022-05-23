package com.example.PokemonBackEndProject.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Trainer {
    // Setting types and objects
//    This auto generates the ID type
    @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int age;
    private String town;



    // links the relationship from trainer to many pokemons that the trainer could own
    @OneToMany(mappedBy = "trainer", cascade = CascadeType.ALL) //CascadeType consists of operation PERSIST, MERGE, REMOVE, REFRESH and DETACH

    private List<Pokemon> pokemons; //listing the pokemon in the database that can be linked to the trainer

    public Trainer(Long id, String name, int age, String town){
        this.id = id;
        this.name = name;
        this.age = age;
        this.town = town;
        this.pokemons = new ArrayList<Pokemon>();
    }

    // no arg constructor

    public Trainer(){
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

}
