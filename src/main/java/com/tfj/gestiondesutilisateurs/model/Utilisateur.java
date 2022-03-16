package com.tfj.gestiondesutilisateurs.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Utilisateur implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id;
    private String nom;
    private String email;
    private String emploi;
    private String numero;
    private String imageUrl;
    @Column(nullable = false, updatable = false)
    private String utilisateurCode;

    public Utilisateur() {}

    public Utilisateur(String nom, String email, String emploi, String numero, String imageUrl, String utilisateurCode) {
        this.nom = nom;
        this.email = email;
        this.emploi = emploi;
        this.numero = numero;
        this.imageUrl = imageUrl;
        this.utilisateurCode = utilisateurCode;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmploi() {
        return emploi;
    }

    public void setEmploi(String emploi) {
        this.emploi = emploi;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getUtilisateurCode() {
        return utilisateurCode;
    }

    public void setUtlisateurCode(String utilisateurCode) {
        this.utilisateurCode = utilisateurCode;
    }

    @Override
    public String toString() {
        return "Utilisateur{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", email='" + email + '\'' +
                ", emploi='" + emploi + '\'' +
                ", numero='" + numero + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                '}';
    }
}
