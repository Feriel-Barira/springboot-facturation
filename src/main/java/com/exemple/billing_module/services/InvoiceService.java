package com.exemple.billing_module.services;

import com.exemple.billing_module.dto.InvoiceDTO;
import com.exemple.billing_module.dto.InvoiceLineDTO;
import com.exemple.billing_module.models.Client;
import com.exemple.billing_module.models.Invoice;
import com.exemple.billing_module.models.InvoiceLine;
import com.exemple.billing_module.repositories.ClientRepository;
import com.exemple.billing_module.repositories.InvoiceRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class InvoiceService {
    @Autowired
    private InvoiceRepository invoiceRepository;
    @Autowired
    private ClientRepository clientRepository;

    // créer une facture à partir d'un DTO
    public Invoice createInvoice(InvoiceDTO invoiceDTO) {
        if (invoiceDTO.getLines() == null || invoiceDTO.getLines().isEmpty()) {
            throw new IllegalArgumentException("Une facture doit contenir au moins une ligne !");
        }
        // récupération du client
        Client client = clientRepository.findById(invoiceDTO.getClientId())
                .orElseThrow(() -> new IllegalArgumentException("Client non trouvé avec ID: " + invoiceDTO.getClientId()));

        // création de la facture
        Invoice invoice = new Invoice();
        invoice.setClient(client);
        invoice.setDate(LocalDate.now()); // ✅ date auto-générée

        List<InvoiceLine> lines = new ArrayList<>();
        BigDecimal totalHT = BigDecimal.ZERO;
        BigDecimal totalTVA = BigDecimal.ZERO;

        // construction des lignes de facture
        for (InvoiceLineDTO lineDTO : invoiceDTO.getLines()) {
            if (lineDTO.getQuantity() <= 0 || lineDTO.getUnitPrice().compareTo(BigDecimal.ZERO) <= 0) {
                throw new IllegalArgumentException("Quantité et prix doivent être > 0 !");
            }
            if (!(lineDTO.getTva() == 0 || lineDTO.getTva() == 5.5 || lineDTO.getTva() == 10 || lineDTO.getTva() == 20)) {
                throw new IllegalArgumentException("Taux de TVA invalide !");
            }

            InvoiceLine line = new InvoiceLine();
            line.setDescription(lineDTO.getDescription());
            line.setQuantity(lineDTO.getQuantity());
            line.setUnitPrice(lineDTO.getUnitPrice());
            line.setTva(lineDTO.getTva());
            line.setInvoice(invoice);

            // calcul ligne
            BigDecimal lineTotalHT = lineDTO.getUnitPrice().multiply(BigDecimal.valueOf(lineDTO.getQuantity()));
            BigDecimal lineTVA = lineTotalHT.multiply(BigDecimal.valueOf(lineDTO.getTva() / 100.0));

            totalHT = totalHT.add(lineTotalHT);
            totalTVA = totalTVA.add(lineTVA);

            lines.add(line);
        }

        // calcul des totaux
        invoice.setLines(lines);
        invoice.setTotalHT(totalHT);
        invoice.setTotalTVA(totalTVA);
        invoice.setTotalTTC(totalHT.add(totalTVA));

        // enregistrer
        return invoiceRepository.save(invoice);
    }

    // lister toutes les factures
    public List<Invoice> getAllInvoices() {
        return invoiceRepository.findAll();
    }

    // lister factures d'un client
    public List<Invoice> getInvoicesByClient(Long clientId) {
        return invoiceRepository.findByClientId(clientId);
    }

    // lister factures par date
    public List<Invoice> getInvoicesByDate(LocalDate date) {
        return invoiceRepository.findByDate(date);
    }
    public Invoice getInvoiceById(Long id) {
        return invoiceRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Invoice not found with id: " + id));
    }

}


