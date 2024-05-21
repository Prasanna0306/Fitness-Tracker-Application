package com.project.fitness.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.fitness.model.Nutritionist;
import com.project.fitness.repo.NutritionistRepo;

@Service
public class NutritionistService {
        @Autowired
        NutritionistRepo nutritionistRepo ;

        public Nutritionist createnutritionist(Nutritionist nutritionist){
            return nutritionistRepo.save(nutritionist);
        }


        public Optional<Nutritionist> getnutritionist(int id){
            return nutritionistRepo.findById(id);
        }
        
        public List<Nutritionist> getnutritionists(){
            return nutritionistRepo.findAll();
        }
        
        public void deletenutritionist(int id){
            nutritionistRepo.deleteById(id);
        }

        

}
