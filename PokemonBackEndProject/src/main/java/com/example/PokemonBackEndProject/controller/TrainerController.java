package com.example.PokemonBackEndProject.controller;

import com.example.PokemonBackEndProject.Service.TrainerService;
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
    private TrainerService trainerService;
    @Autowired
//    This glues this class to the repository class
    private final TrainerRepository trainerRepository;

    public TrainerController(TrainerRepository trainerRepository, TrainerService trainerService) {
        this.trainerRepository = trainerRepository;
        this.trainerService = trainerService;
    }
//  Get all Trainers

   @GetMapping("/trainer")
    public ResponseEntity<List<Trainer>> getAllTrainers(){
        return new ResponseEntity<>(trainerRepository.findAll(), HttpStatus.OK);
   }

   // GET MAP FOR TRAINER QUERY
//    Find the trainer by town
    @GetMapping("/trainer/town")
    public ResponseEntity<List<Trainer>> getTrainerByTown (@RequestParam(required = false, name = "town") String town) {
        if (town != null) {
            return new ResponseEntity<>(trainerRepository.findByTown(town), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(trainerRepository.findAll(), HttpStatus.OK);
        }
    }

   @PostMapping("/trainer")
//   This adds a new trainer and assigns it to an existing Pokemon.
    public ResponseEntity<List<Trainer>> postTrainer(@RequestBody Trainer trainer){
        trainerRepository.save(trainer);
        return new ResponseEntity<>(trainerRepository.findAll(), HttpStatus.CREATED);
   }

   @PutMapping("/trainer/{id}")
// Change the town of the trainer
// These are the parameters for the method (PathVariable to String town)
   /*
   When looking at this in th path is localhost:8080.... trainer/id where id is a specific number (the id of the trainer
   you want to update.
    */
    public void updateTrainer(
            @PathVariable("id") Long trainerId,
            @RequestParam(required = false) String town) {
                trainerService.updateTrainer(trainerId, town);}

    // DELETE
    // deletes a trainer by id
    @DeleteMapping(path = {"/trainer/{id}"})
    public void deleteTrainer(@PathVariable("id") Long trainerId) {
        trainerService.deleteTrainer(trainerId);
    }
}
