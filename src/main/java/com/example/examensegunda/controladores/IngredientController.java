package com.example.examensegunda.controladores;

import com.example.examensegunda.dto.NewIngredientRequestDto;
import com.example.examensegunda.servicios.IngredientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/ingredients")
public class IngredientController {

    private final IngredientService ingredientService;

    @Autowired
    public IngredientController(IngredientService ingredientService) {
        this.ingredientService = ingredientService;
    }

    @DeleteMapping("/{ingredientId}")
    public ResponseEntity<String> deleteIngredientById(@PathVariable short ingredientId) {
        if (ingredientService.deleteIngredientById(ingredientId)) {
            return new ResponseEntity<>("Ingredient deleted successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Unable to delete. Ingredient is being used in recipes.", HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping()
    public ResponseEntity<Void> createIngredient(@RequestBody NewIngredientRequestDto requestDto) {
        ingredientService.createIngredient(requestDto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

}
