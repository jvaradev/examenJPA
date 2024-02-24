// RecipeService.java
package com.example.examensegunda.servicios;

import com.example.examensegunda.dto.RecipeDto;
import com.example.examensegunda.repositorios.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecipeService {

    private final RecipeRepository recipeRepository;

    @Autowired
    public RecipeService(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    public List<RecipeDto> getRecipesByNumberOfPeople(short numberOfPeople) {
        return recipeRepository.findByPeople(numberOfPeople);
    }
}
