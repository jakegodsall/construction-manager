package com.jakegodsall.constructionmanager.service.impl;

import com.jakegodsall.constructionmanager.entity.Customer;
import com.jakegodsall.constructionmanager.exception.ResourceNotFoundException;
import com.jakegodsall.constructionmanager.mapper.CustomerMapper;
import com.jakegodsall.constructionmanager.payload.CustomerDto;
import com.jakegodsall.constructionmanager.repository.CustomerRepository;
import com.jakegodsall.constructionmanager.service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;

    @Override
    public List<CustomerDto> getAllCustomers() {
        // Extract all Customer entities, map to DTO and return
        return customerRepository.findAll()
                .stream()
                .map(customerMapper::customerToCustomerDto)
                .toList();
    }

    @Override
    public CustomerDto getCustomerById(Long id) {
        // Find the entity in the db by id
        Customer customer = customerRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Customer", "id", id)
        );
        // Map the entity to DTO and return
        return customerMapper.customerToCustomerDto(customer);
    }

    @Override
    public CustomerDto createCustomer(CustomerDto customerDto) {
        // Map the DTO to entity
        Customer customer = customerMapper.customerDtoToCustomer(customerDto);
        // Save the entity in the db
        Customer customerInDb = customerRepository.save(customer);
        // Map the saved entity to DTO and return
        return this.customerMapper.customerToCustomerDto(customerInDb);
    }

    @Override
    public CustomerDto updateCustomer(CustomerDto customerDto, Long id) {
        // Get Customer entity from the database
        Customer customer = customerRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Customer", "id", id)
        );
        // Update the Customer entity with the values from the provided DTO.
        customer.setFirstName(customerDto.getFirstName());
        customer.setLastName(customerDto.getLastName());
        customer.setPhoneNumber(customerDto.getPhoneNumber());
        customer.setEmailAddress(customerDto.getEmailAddress());
        // Save the entity in the database
        customerRepository.save(customer);
        // Map to DTO and return
        return customerMapper.customerToCustomerDto(customer);
    }

    @Override
    public void deleteCustomer(Long id) {
        // Get the Customer entity from the database
        Customer customer = customerRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Customer", "id", id)
        );
        // Delete the entity from the db
        customerRepository.delete(customer);
    }
}
