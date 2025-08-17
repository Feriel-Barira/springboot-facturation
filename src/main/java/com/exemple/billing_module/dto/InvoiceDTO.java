package com.exemple.billing_module.dto;

import java.util.List;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class InvoiceDTO {

    @NotNull(message = "le clientId est obligatoire")
    private Long clientId;

    // chaque facture doit avoir au moins une ligne
    @NotNull(message = "la liste des lignes ne peut pas être nulle")
    @Size(min = 1, message = "la facture doit contenir au moins une ligne")
    private List<InvoiceLineDTO> lines;

    // constructeurs
    public InvoiceDTO() {}

    public InvoiceDTO(Long clientId, List<InvoiceLineDTO> lines) {
        this.clientId = clientId;
        this.lines = lines;
    }

    // getters et setters
    public Long getClientId() { return clientId; }
    public void setClientId(Long clientId) { this.clientId = clientId; }

    public List<InvoiceLineDTO> getLines() { return lines; }
    public void setLines(List<InvoiceLineDTO> lines) { this.lines = lines; }
}
