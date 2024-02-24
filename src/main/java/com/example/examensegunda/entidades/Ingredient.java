package com.example.examensegunda.entidades;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Entity
@Setter
@EqualsAndHashCode
public class Ingredient {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ingredient_id", nullable = false)
    @EqualsAndHashCode.Include
    private short ingredientId;
    @Basic
    @Column(name = "name", nullable = false,length = 100)
    private String name;
    @OneToMany(mappedBy = "ingredient", cascade = CascadeType.ALL)
    private List<RecipeIngredient> recipeIngredients;
}
