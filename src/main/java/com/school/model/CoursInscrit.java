package com.school.model;

import com.school.enumeration.StatutCoursInscrit;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

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

