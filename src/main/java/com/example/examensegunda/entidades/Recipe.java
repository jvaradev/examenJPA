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
public class Recipe {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "recipe_id", nullable = false)
    @EqualsAndHashCode.Include
    private short recipeId;
    @Basic
    @Column(name = "description", length = 2000)
    private String name;
    @Basic
    @Column(name = "number_of_people", nullable = false)
    private short people;
    @Basic
    @Column(name = "time_in_minutes", nullable = false)
    private short time;
    @Basic
    @Column(name = "title", nullable = false, length = 100)
    private String title;
    @OneToMany(mappedBy = "recipe", cascade = CascadeType.ALL)
    private List<Step> steps;
    @OneToMany(mappedBy = "recipe", cascade = CascadeType.ALL)
    private List<RecipeIngredient> recipeIngredients;
}
