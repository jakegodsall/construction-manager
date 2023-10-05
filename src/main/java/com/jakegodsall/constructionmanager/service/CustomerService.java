package com.jakegodsall.constructionmanager.service;

import com.jakegodsall.constructionmanager.entity.Customer;
import com.jakegodsall.constructionmanager.payload.CustomerDto;

import java.util.List;

public interface CustomerService {
    List<CustomerDto> getAllCustomers();
    CustomerDto getCustomerById(Long id);
    CustomerDto createCustomer(CustomerDto customerDto);
    CustomerDto updateCustomer(CustomerDto customerDto, Long id);
    void deleteCustomer(Long id);
}
