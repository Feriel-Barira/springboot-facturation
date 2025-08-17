package com.exemple.billing_module.dto;

import java.math.BigDecimal;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class InvoiceLineDTO {

    @NotBlank(message = "la description est obligatoire")
    private String description;

    @NotNull(message = "la quantité est obligatoire")
    @Min(value = 1, message = "La quantité doit être au moins 1")
    private Integer quantity;

    @NotNull(message = "le prix unitaire est obligatoire")
    @DecimalMin(value = "0.0", inclusive = true, message = "Le prix unitaire doit être positif ou zéro")
    private BigDecimal unitPrice;

    @NotNull(message = "la TVA est obligatoire")
    @DecimalMin(value = "0.0", inclusive = true, message = "La TVA doit être positive ou zéro")
    private Double tva;

    // constructeurs
    public InvoiceLineDTO() {}

    public InvoiceLineDTO(String description, Integer quantity, BigDecimal unitPrice, Double tva) {
        this.description = description;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
        this.tva = tva;
    }

    // getters et setters
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public Integer getQuantity() { return quantity; }
    public void setQuantity(Integer quantity) { this.quantity = quantity; }

    public BigDecimal getUnitPrice() { return unitPrice; }
    public void setUnitPrice(BigDecimal unitPrice) { this.unitPrice = unitPrice; }

    public Double getTva() { return tva; }
    public void setTva(Double tva) { this.tva = tva; }
}
