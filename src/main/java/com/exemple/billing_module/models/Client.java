package com.exemple.billing_module.models;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "clients")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
    private String siret;

    private LocalDate createdAt;
    // constructeurs
    public Client() {}
    public Client(String name, String email, String siret) {
        this.name = name;
        this.email = email;
        this.siret = siret;
    }
    // createdAt sera automatiquement généré
    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDate.now();
    }

    // getters et setters 
    public Long getId() {
        return id;
    }

    public void setId(Long id) { this.id = id; }

    public String getName() {
        return name;
    }

    public void setName(String name) { this.name = name; }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) { this.email = email; }

    public String getSiret() {
        return siret;
    }

    public void setSiret(String siret) { this.siret = siret; }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) { this.createdAt = createdAt; }
}





