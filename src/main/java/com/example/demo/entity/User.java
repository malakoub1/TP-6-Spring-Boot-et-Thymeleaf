package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;

@Entity
public class User {

    // Identifiant unique généré automatiquement
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    // Le nom ne doit pas être vide
    @NotBlank(message = "Le nom est obligatoire")
    private String name;

    // L'email ne doit pas être vide
    @NotBlank(message = "L'email est obligatoire")
    private String email;

    // Constructeur par défaut requis par JPA
    public User() {
    }

    // Getter de l'identifiant
    public Long getId() {
        return id;
    }

    // Setter de l'identifiant
    public void setId(Long id) {
        this.id = id;
    }

    // Getter du nom
    public String getName() {
        return name;
    }

    // Setter du nom
    public void setName(String name) {
        this.name = name;
    }

    // Getter de l'email
    public String getEmail() {
        return email;
    }

    // Setter de l'email
    public void setEmail(String email) {
        this.email = email;
    }
}