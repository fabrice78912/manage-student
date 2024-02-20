package com.school.model;

import com.school.enumeration.StatutInscription;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "inscription")
public class Inscription {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "etudiant_id")
    //@NotNull
    private Etudiant etudiant;

    @ManyToOne
    @JoinColumn(name = "programme_id")
    //@NotNull
    private Programme programme;

    @Enumerated(EnumType.STRING)
    //@NotNull
    private StatutInscription statut;


    @OneToMany(mappedBy = "inscription", cascade = CascadeType.ALL)
    private List<CoursInscrit> coursInscrits;

    @OneToMany(mappedBy = "inscription", cascade = CascadeType.ALL)
    private List<FraisInscription> fraisInscriptions;

    // Getters, Setters, Constructeurs

}
