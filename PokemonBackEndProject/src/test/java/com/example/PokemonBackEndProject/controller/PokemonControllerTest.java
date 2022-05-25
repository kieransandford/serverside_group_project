package com.example.PokemonBackEndProject.controller;

import com.example.PokemonBackEndProject.repository.PokemonRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(SpringExtension.class)
@WebMvcTest(PokemonController.class)
class PokemonControllerTest {

//    @Autowired
//    private MockMvc mvc;
//    @MockBean
//    private PokemonRepository pokemonRepository;
//
//    @Test
//    public void getAllPokemon() throws Exception {
//        RequestBuilder request = MockMvcRequestBuilders.get("/pokemon");
//        MvcResult result = mvc.perform(request).andReturn();
//        assertEquals(result, pokemonRepository.findAll());
//    }
}