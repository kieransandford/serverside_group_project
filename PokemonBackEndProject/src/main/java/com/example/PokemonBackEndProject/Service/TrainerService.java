package com.example.PokemonBackEndProject.Service;

import com.example.PokemonBackEndProject.model.Trainer;
import com.example.PokemonBackEndProject.repository.TrainerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Objects;


@Service
public class TrainerService {
    @Autowired
//    Glues this class to TrainerRepository class
    private TrainerRepository trainerRepository;
    
    public TrainerService(){
    }

    public TrainerRepository getTrainerRepository() {
        return trainerRepository;
    }

    public void setTrainerRepository(TrainerRepository trainerRepository) {
        this.trainerRepository = trainerRepository;
    }
    @Transactional
    /* Find the trainer you want to update by id. If you cannot find it, display message that it does not exist.
    If the town of that trainer is not null and is not equal to the town value you are trying to input, set the town
    to the new town value that you have input.
     */
    public void updateTrainer(Long trainerId, String town) {
        Trainer trainer = trainerRepository.findById(trainerId).
                orElseThrow(() -> new IllegalStateException("Trainer with " + trainerId + " does not exist."));
        if (town != null && town.length() > 0 && !Objects.equals(trainer.getTown(), town)){
            trainer.setTown(town);
        }
    }

    // DELETE MAPPING
    public void deleteTrainer(Long trainerId) {
        boolean exists = trainerRepository.existsById(trainerId);
        if (!exists) {
            throw new IllegalStateException(
                "trainer with id " + trainerId + "does not exist");
            }
        trainerRepository.deleteById(trainerId);
    }

}
