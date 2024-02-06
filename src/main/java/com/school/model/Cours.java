package com.school.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cours {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String nomCours;

    @NotBlank
    private String codeCours;

    @Positive
    private int credits;

    @OneToMany(mappedBy = "cours", cascade = CascadeType.ALL)
    private List<CoursInscrit> coursInscrits;


}

