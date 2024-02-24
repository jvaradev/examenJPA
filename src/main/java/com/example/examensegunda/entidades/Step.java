package com.example.examensegunda.entidades;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Entity
@Setter
@EqualsAndHashCode
public class Step {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "step_id", nullable = false)
    @EqualsAndHashCode.Include
    private short stepId;
    @Basic
    @Column(name = "description", nullable = false,length = 255)
    private String description;
    @Basic
    @Column(name = "step_order", nullable = false)
    private short stepOrder;
    @ManyToOne
    @JoinColumn(name = "recipe_id", nullable = false)
    private Recipe recipe;
}
