package com.example.PokemonBackEndProject;

import com.example.PokemonBackEndProject.model.Business;
import com.example.PokemonBackEndProject.model.Pokemon;
import com.example.PokemonBackEndProject.model.Trainer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

public class BusinessTests {

Business business;
Trainer trainer;

Pokemon pokemon;
Pokemon pokemon1;


@BeforeEach
public void setUp(){
    trainer = new Trainer(1L,"Test",24,"Test",20);
    pokemon = new Pokemon(1L,"Poke","Fairy",GenerationList.Kanto,234,10,trainer);
// <<<<<<< feature-Testing-M
//     pokemon1 = new Pokemon(2L,"poke2","Dragon",GenerationList.Kalos,433,30,trainer);
// =======
//     pokemon1 = new Pokemon(2L,"poke2","Dragon",GenerationList.Hoenn,433,30,trainer);
//     business = new Business("Poke Mart",200);
//     business.addPoke(pokemon);
//     business.addPoke(pokemon1);
//     business.setTill(200);


// >>>>>>> main
}

// Testing to see if the canBuy method can tell the trainer they can or cannot afford the pokemon
@Test
    public void canBuy(){
    trainer.canBuy(pokemon1);
   // assertFalse(trainer.canBuy(pokemon1));
    assertTrue(trainer.canBuy(pokemon));
    //assertEquals(10,trainer.getWallet());
}

// checks to see if the stock of the poke mart decreases by 1
// checks to see if the poke mart selling the pokemon to the trainer increases the tills count
// also decreases the trainers wallet amount from the price of the pokemon
// Increases the trainers count of pokemon by 1
@Test
    public void sellPokemon(){
    business.sellPokemon(trainer, pokemon);
    assertThat(business.pokeCount()).isEqualTo(1);
    assertThat(business.getTill()).isEqualTo(210);
    assertThat(trainer.getWallet()).isEqualTo(10);
    assertThat(trainer.getPokemonCount()).isEqualTo(1);
}

@Test
    public void addPoke(){
    assertThat(business.pokeCount()).isEqualTo(2);
}

}
