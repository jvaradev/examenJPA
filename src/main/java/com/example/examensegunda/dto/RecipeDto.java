package com.example.examensegunda.dto;

import java.util.List;

public interface RecipeDto {
    String getTitle();
    short getRecipeId();
    short getTime();
    short getPeople();
    List<RecipeIngredientDto> getRecipeIngredients();
    List<StepDto> getSteps();

    interface RecipeIngredientDto {
        short getQuantity();
        IngredientDto getIngredient();

        interface IngredientDto {
            String getName();
        }
    }

    interface StepDto {
        String getDescription();
        short getStepOrder();
    }
}
