package com.school.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Programme {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //@NotBlank
    private String nom;


    // @Positive
    private int duree;

    @OneToMany(mappedBy = "programme", cascade = CascadeType.ALL)
    private List<Inscription> inscriptions;

    // Getters, Setters, Constructeurs

}
