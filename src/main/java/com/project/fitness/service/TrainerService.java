package com.project.fitness.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.fitness.model.Trainer;
import com.project.fitness.repo.TrainerRepo;
import com.project.fitness.repo.UserRepository;

@Service
public class TrainerService {
    @Autowired
    TrainerRepo trainerRepo;
    @Autowired
    UserRepository userRepository;

    // CREATING THE TRAINER 
    public Trainer addTrainer(Trainer trainer){
        return trainerRepo.save(trainer);
    }

    // FIND THE TRAINER BY ID
    public Optional<Trainer> findtrainerbyid(int id){
        return trainerRepo.findById(id);
    }

    //FIND ALL THE TRAINERS 
    public List<Trainer> getAllTrainers(){
        return trainerRepo.findAll();
    }

    // DELETE THE TRAINER BY TRAINER ID HER id REFERS TO TRAINER ID;
    public void deleteTrainer(int id){
        trainerRepo.deleteById(id);
    }

    public Trainer updateTrainer(Trainer trainer){
        return trainerRepo.save(trainer);
    }

    

}
