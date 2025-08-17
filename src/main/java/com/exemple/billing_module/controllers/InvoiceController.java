package com.exemple.billing_module.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.exemple.billing_module.services.InvoiceService;
import com.exemple.billing_module.models.Invoice;
import com.exemple.billing_module.dto.InvoiceDTO;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/invoices")
public class InvoiceController {
    @Autowired
    private InvoiceService invoiceService;
     
    // lister toutes les factures
    @GetMapping
    public List<Invoice> getAllInvoices() {
        return invoiceService.getAllInvoices();
    }
    // créer une facture à partir d'un DTO 
    @PostMapping
    public Invoice createInvoice(@RequestBody InvoiceDTO invoiceDTO) {
        return invoiceService.createInvoice(invoiceDTO);
    }
    //bonus
    // lister les factures d'un client spécifique
    @GetMapping("/client/{clientId}")
    public List<Invoice> getByClient(@PathVariable Long clientId) {
        return invoiceService.getInvoicesByClient(clientId);
    }
    //bonus
    // lister les factures par date
    @GetMapping("/date/{date}")
    public List<Invoice> getByDate(@PathVariable String date) {
        return invoiceService.getInvoicesByDate(LocalDate.parse(date));
    }
    // export endpoint
    @GetMapping("/{id}/export")
    public Invoice exportInvoice(@PathVariable Long id) {
        return invoiceService.getInvoiceById(id);
    }
}
