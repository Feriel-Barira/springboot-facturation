package com.exemple.billing_module.models;


import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
public class InvoiceLine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;
    private Integer quantity;
    private BigDecimal unitPrice;
    private Double tva;

    @ManyToOne
    @JoinColumn(name = "invoice_id")
    private Invoice invoice;
    // constructeurs
    public InvoiceLine() {}
    public InvoiceLine(String description, Integer quantity, BigDecimal unitPrice, Double tva) {
        this.description = description;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
        this.tva = tva;
    }
    // getters et setters 
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public Integer getQuantity() { return quantity; }
    public void setQuantity(Integer quantity) { this.quantity = quantity; }
    public BigDecimal getUnitPrice() { return unitPrice; }
    public void setUnitPrice(BigDecimal unitPrice) { this.unitPrice = unitPrice; }
    public Double getTva() { return tva; }
    public void setTva(Double tva) { this.tva = tva; }
    public Invoice getInvoice() { return invoice; }
    public void setInvoice(Invoice invoice) { this.invoice = invoice; }
}




    

