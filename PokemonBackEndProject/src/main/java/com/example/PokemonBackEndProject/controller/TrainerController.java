package com.example.PokemonBackEndProject.controller;

import com.example.PokemonBackEndProject.model.Trainer;
import com.example.PokemonBackEndProject.repository.TrainerRepository;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Id;
import java.util.List;

@RestController
public class TrainerController {
    @Autowired
//    This glues this class to the repository class
    private final TrainerRepository trainerRepository;

    public TrainerController(TrainerRepository trainerRepository) {
        this.trainerRepository = trainerRepository;
    }
//  Get all Trainers
   @GetMapping("/trainer")
    public ResponseEntity<List<Trainer>> getAllTrainers(){
        return new ResponseEntity<>(trainerRepository.findAll(), HttpStatus.OK);
   }
   @PostMapping("/trainer")
    public ResponseEntity<List<Trainer>> postTrainer(@RequestBody Trainer trainer){
        trainerRepository.save(trainer);
        return new ResponseEntity<>(trainerRepository.findAll(), HttpStatus.CREATED);
   }





}
