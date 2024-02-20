package com.school.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FraisInscription {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "inscription_id")
    @NotNull
    private Inscription inscription;

    @Positive
    private double montant;

    @NotNull
    private LocalDateTime datePaiement = LocalDateTime.now();

    @NotNull
    private String statut;

    // Getters, Setters, Constructeurs

}

