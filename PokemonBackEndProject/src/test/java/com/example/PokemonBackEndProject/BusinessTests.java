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
    pokemon = new Pokemon(1L,"Poke","Fairy",GenerationList.KANTO,234,10,trainer);
    pokemon1 = new Pokemon(2L,"poke2","Dragon",GenerationList.HOENN,433,30,trainer);
}

@Test
    public void canBuy(){
    trainer.canBuy(pokemon1);
    assertFalse(trainer.canBuy(pokemon1));
    assertTrue(trainer.canBuy(pokemon));
    assertThat(trainer.getPokemonCount()).isEqualTo(trainer.getPokemonCount());
    //assertEquals(10,trainer.getWallet());
}


}
