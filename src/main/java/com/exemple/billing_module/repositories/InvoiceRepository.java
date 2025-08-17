package com.exemple.billing_module.repositories;

import com.exemple.billing_module.models.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface InvoiceRepository extends JpaRepository<Invoice, Long> {

    // récupérer les factures d’un client
    List<Invoice> findByClientId(Long clientId);

    // récupérer les factures par date
    List<Invoice> findByDate(LocalDate date);
}

