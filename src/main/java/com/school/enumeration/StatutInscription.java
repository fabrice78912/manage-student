package com.school.enumeration;

public enum StatutInscription {

    INSCRIT("inscrit"),
    EN_ATTENTE("en attente"),
    ANNULE("annulé");

    private final String libelle;

    StatutInscription(String libelle) {
        this.libelle = libelle;
    }

    public String getLibelle() {
        return libelle;
    }
}
