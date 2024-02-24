package com.example.examensegunda.servicios;

import com.example.examensegunda.dto.NewIngredientRequestDto;
import com.example.examensegunda.entidades.Ingredient;
import com.example.examensegunda.repositorios.IngredientRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.Optional;

@Service
public class IngredientService {

    private final IngredientRepository ingredientRepository;

    @Autowired
    public IngredientService(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }

    public Optional<Ingredient> getIngredientById(short ingredientId) {
        return ingredientRepository.findById(ingredientId);
    }

    public void createIngredient(NewIngredientRequestDto requestDto) {
        Ingredient ingredient = new Ingredient();
        ingredient.setName(requestDto.getName());

        ingredientRepository.save(ingredient);
    }

    @Transactional
    public boolean deleteIngredientById(short ingredientId) {
        Optional<Ingredient> optionalIngredient = ingredientRepository.findById(ingredientId);

        if (optionalIngredient.isPresent()) {
            Ingredient ingredient = optionalIngredient.get();

            if (ingredient.getRecipeIngredients() == null || ingredient.getRecipeIngredients().isEmpty()) {
                ingredientRepository.delete(ingredient);
                return true;
            }
        }

        return false;
    }
}
