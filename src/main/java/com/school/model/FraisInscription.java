package com.school.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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

