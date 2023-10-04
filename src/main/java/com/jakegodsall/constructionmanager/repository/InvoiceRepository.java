package com.jakegodsall.constructionmanager.repository;

import com.jakegodsall.constructionmanager.entity.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvoiceRepository extends JpaRepository<Invoice, Long> {
}
