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
    // unique logic methods to call upon:

    // Adds money to the till when a trainer makes a successful purchase from the shop.
    // Also removes the pokemon from its list. i.e. removes it from its stock
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


public int pokeCount(){
        return this.pokemon.size();
}

public void addPoke(Pokemon pokemon){
        this.pokemon.add(pokemon);
}


    //getters and setters
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