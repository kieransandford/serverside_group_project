package com.example.PokemonBackEndProject.model;

import java.util.ArrayList;
import java.util.List;

public class Business {
// defining variables
    private String nameshop;
    private double till;
    private ArrayList<Pokemon> pokemon;

//Constructor
    public Business(String nameshop, double till) {
        this.nameshop = nameshop;
        this.till = 0;
        this.pokemon = new ArrayList<>() {
        };
    }
// unique methods to call upon
    public void sellPokemon(Trainer trainer, Pokemon pokemon) {
        if (trainer.canBuy(pokemon) == true) {
            trainer.buyPokemon(pokemon);
            this.pokemon.remove(pokemon);
            setTill(this.till + pokemon.getPrice());
        }
    }

        public double calcPokeValue(){
            double total = 0;
            for(Pokemon pokemon : this.pokemon){
                total += pokemon.getPrice();
            }
            return total;
        }
        //getters and setters

public int pokeCount(){
        return this.pokemon.size();
}

public void addPoke(Pokemon pokemon){
        this.pokemon.add(pokemon);
}

    public String getNameshop() {
        return nameshop;
    }

    public void setNameshop(String nameshop) {
        this.nameshop = nameshop;
    }

    public double getTill() {
        return till;
    }

    public void setTill(double till) {
        this.till = till;
    }

    public ArrayList getPokemon() {
        return pokemon;
    }

    public void setPokemon(ArrayList pokemon) {
        this.pokemon = pokemon;
    }
}