package com.school.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import java.util.Date;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EtudiantRequestDto {


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

}
