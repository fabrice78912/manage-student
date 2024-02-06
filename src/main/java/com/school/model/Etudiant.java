package com.school.model;

import com.school.validation.UniqueValue;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Etudiant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //@NotBlank
    @Column(unique = true)
    //@UniqueValue
    private String matriculeEtudiant;

    @NotBlank
    private String nom;

    @NotBlank
    private String prenom;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Past
    private Date dateNaissance;

    @NotBlank
    private String lieuNaissance;

    @NotBlank
    private String genre;

    @NotBlank
    private String nationalite;

    @NotBlank
    private String motDePasse;

    @NotBlank
    private String adressePostale;

    @NotBlank
    @Email
    //@UniqueValue
    @Column(unique = true)
    private String adresseEmail;

    @NotBlank
    @Pattern(regexp = "\\d{10}", message = "Le numéro de téléphone doit contenir 10 chiffres")
    private String numeroTelephone;

    // Photo: Image récente de l'étudiant - You may use a data type like byte[] or String for the image path.

    @NotBlank
    private String contactUrgence;

    @NotBlank
    private String relationContactUrgence;

    @NotBlank
    private String nomPrenomParents;

    @NotBlank
    private String contactsParents;

    // Historique Académique
    @ElementCollection
    private List<String> etablissementsFrequentes;

    @ElementCollection
    private List<String> diplomesObtenus;

    // Données Sensibles
    private String informationsMedicales;

    private String besoinsSpecifiques;

    // Autorisations et Consentements
    private boolean consentementUtilisationDonnees;

    private boolean autorisationParentaleMineur;

    // Préférences Linguistiques
    @NotBlank
    private String languePreferree;

    // Historique des Activités Parascolaires
    @ElementCollection
    private List<String> activitesParascolaires;

    // Identifiants Réseaux Sociaux
    private String liensReseauxSociaux;

    // Documents Administratifs
    @ElementCollection
    private List<String> piecesIdentite;

    @ElementCollection
    private List<String> certificatsScolarite;

    // Autorisations pour la Publication
    private boolean consentementPublication;


    @OneToMany(mappedBy = "etudiant", cascade = CascadeType.ALL)
    private List<Inscription> inscriptions;




}
