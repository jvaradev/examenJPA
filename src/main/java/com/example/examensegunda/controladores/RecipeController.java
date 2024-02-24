package com.example.examensegunda.controladores;

import com.example.examensegunda.dto.RecipeDto;
import com.example.examensegunda.servicios.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/recipes")
public class RecipeController {

    private final RecipeService recipeService;

    @Autowired
    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @GetMapping("/by-people/{numberOfPeople}")
    public List<RecipeDto> getRecipesByNumberOfPeople(@PathVariable short numberOfPeople) {
        return recipeService.getRecipesByNumberOfPeople(numberOfPeople);
    }
}
