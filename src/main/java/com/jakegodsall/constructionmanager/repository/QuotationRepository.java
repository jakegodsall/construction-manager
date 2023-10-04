package com.jakegodsall.constructionmanager.repository;

import com.jakegodsall.constructionmanager.entity.Quotation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuotationRepository extends JpaRepository<Quotation, Long> {
}
