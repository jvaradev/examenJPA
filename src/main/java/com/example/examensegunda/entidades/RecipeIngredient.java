package com.example.examensegunda.entidades;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Entity
@Setter
@EqualsAndHashCode
@Table(uniqueConstraints = {
        @UniqueConstraint(columnNames = {"recipe_id", "ingredient_id"})
})
public class RecipeIngredient {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "recipe_ingredient_id", nullable = false)
    @EqualsAndHashCode.Include
    private short recipeIngredientId;
    @Basic
    @Column(name = "quantity", nullable = false)
    private Short quantity;
    @ManyToOne
    @JoinColumn(name = "recipe_id", nullable = false)
    private Recipe recipe;
    @ManyToOne
    @JoinColumn(name = "ingredient_id", nullable = false)
    private Ingredient ingredient;
}
