package com.exemple.billing_module.dto;

import java.time.LocalDate;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class ClientDTO {
    private Long id;  // auto-généré
    @NotBlank(message = "le nom est obligatoire")
    private String name;
    @Email(message = "email invalide")
    @NotBlank(message = "l'email est obligatoire")
    private String email;
    @NotBlank(message = "le SIRET est obligatoire")
    private String siret;
    private LocalDate createdAt; // auto-généré

    // constructeur par défaut
    public ClientDTO() {}

    // constructeur complet
    public ClientDTO(Long id, String name, String email, String siret, LocalDate createdAt) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.siret = siret;
        this.createdAt = createdAt;
    }

    // getters et setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getSiret() { return siret; }
    public void setSiret(String siret) { this.siret = siret; }

    public LocalDate getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDate createdAt) { this.createdAt = createdAt; }
}

