package com.project.fitness.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.project.fitness.model.Trainer;


import com.project.fitness.service.TrainerService;

@RestController
@RequestMapping("/trainer")
public class TrainerController {
    @Autowired
    public TrainerService trainerService;
    @Secured("ROLE_ADMIN")
    @PostMapping("/create")
    public ResponseEntity<Trainer> createTrainer(@RequestBody Trainer trainer){
        Trainer newTrainer = trainerService.addTrainer(trainer);
        return ResponseEntity.status(HttpStatus.CREATED).body(newTrainer);
    }
    @Secured("ROLE_ADMIN")
    @GetMapping("/findbyid/{id}")
    public ResponseEntity<Trainer> findbyid( @PathVariable int id){
       Optional<Trainer>trainer = trainerService.findtrainerbyid(id);
       if(trainer.isPresent()){
        return ResponseEntity.status(HttpStatus.OK).body(trainer.get());
       }
        else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
       }
       @Secured("ROLE_ADMIN")
       @GetMapping("/findall")
        public ResponseEntity<List<Trainer>> getAllTrainers() {
        List<Trainer> trainers = trainerService.getAllTrainers();    
        return new ResponseEntity<>(trainers,HttpStatus.FOUND);
        }

        @DeleteMapping("/delete/{id}")
        public ResponseEntity<String> deleteTrainer(@PathVariable int id){
            trainerService.deleteTrainer(id);
            return ResponseEntity.status(HttpStatus.OK).body("Trainer deleted");
    }


    }

    



    

