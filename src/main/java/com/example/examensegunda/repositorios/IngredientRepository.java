package com.example.examensegunda.repositorios;

import com.example.examensegunda.entidades.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IngredientRepository extends JpaRepository<Ingredient, Short> {
    // Puedes agregar métodos específicos si es necesario
}
