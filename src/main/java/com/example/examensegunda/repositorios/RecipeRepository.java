package com.example.examensegunda.repositorios;

import com.example.examensegunda.dto.RecipeDto;
import com.example.examensegunda.entidades.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RecipeRepository extends JpaRepository<Recipe, Long> {
    List<RecipeDto> findByPeople(short numberOfPeople);
}
