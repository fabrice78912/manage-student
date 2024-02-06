package com.school.enumeration;

public enum StatutCoursInscrit {
    INSCRIT("inscrit"),
    REUSSI("réussi"),
    ECHOUE("échoué");

    private final String libelle;

    StatutCoursInscrit(String libelle) {
        this.libelle = libelle;
    }

    public String getLibelle() {
        return libelle;
    }
}

