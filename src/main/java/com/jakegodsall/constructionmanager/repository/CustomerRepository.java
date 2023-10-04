package com.jakegodsall.constructionmanager.repository;

import com.jakegodsall.constructionmanager.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
