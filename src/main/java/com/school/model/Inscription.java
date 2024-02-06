package com.school.model;

import com.school.enumeration.StatutInscription;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Inscription {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "etudiant_id")
    @NotNull
    private Etudiant etudiant;

    @ManyToOne
    @JoinColumn(name = "programme_id")
    @NotNull
    private Programme programme;

    @Enumerated(EnumType.STRING)
    @NotNull
    private StatutInscription statut;


    @OneToMany(mappedBy = "inscription", cascade = CascadeType.ALL)
    private List<CoursInscrit> coursInscrits;

    @OneToMany(mappedBy = "inscription", cascade = CascadeType.ALL)
    private List<FraisInscription> fraisInscriptions;

    // Getters, Setters, Constructeurs

}
