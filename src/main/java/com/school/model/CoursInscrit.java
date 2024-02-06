package com.school.model;

import com.school.enumeration.StatutCoursInscrit;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CoursInscrit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "inscription_id")
    @NotNull
    private Inscription inscription;

    @ManyToOne
    @JoinColumn(name = "cours_id")
    @NotNull
    private Cours cours;

    @Enumerated(EnumType.STRING)
    @NotNull
    private StatutCoursInscrit status;

    @PositiveOrZero
    private double note;

}

