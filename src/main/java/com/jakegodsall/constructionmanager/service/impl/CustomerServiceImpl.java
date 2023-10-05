package com.jakegodsall.constructionmanager.service.impl;

import com.jakegodsall.constructionmanager.entity.Customer;
import com.jakegodsall.constructionmanager.exception.ResourceNotFoundException;
import com.jakegodsall.constructionmanager.payload.CustomerDto;
import com.jakegodsall.constructionmanager.repository.CustomerRepository;
import com.jakegodsall.constructionmanager.service.CustomerService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    private CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public List<CustomerDto> getAllCustomers() {
        // Extract all Customer entities, map to DTO and return
        return customerRepository.findAll()
                .stream()
                .map(this::mapToDto)
                .toList();
    }

    @Override
    public CustomerDto getCustomerById(Long id) {
        // Find the entity in the db by id
        Customer customer = customerRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Customer", "id", id)
        );
        // Map the entity to DTO and return
        return this.mapToDto(customer);
    }

    @Override
    public CustomerDto createCustomer(CustomerDto customerDto) {
        System.out.println("CUSTOMER DTO");
        System.out.println(customerDto);
        // Map the DTO to entity
        Customer customer = this.mapToEntity(customerDto);
        System.out.println("CUSTOMER");
        System.out.println(customer);
        // Save the entity in the db
        Customer customerInDb = customerRepository.save(customer);
        // Map the saved entity to DTO and return
        return this.mapToDto(customerInDb);
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
        customer.setCreatedDate(customerDto.getCreatedDate());
        customer.setLastModifiedDate(customerDto.getLastModifiedDate());
        // Save the entity in the database
        customerRepository.save(customer);
        // Map to DTO and return
        return this.mapToDto(customer);
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


    private Customer mapToEntity(CustomerDto customerDto) {
        // Map from DTO to entity
        Customer customer = new Customer();
        customer.setId(customerDto.getId());
        customer.setFirstName(customerDto.getFirstName());
        customer.setLastName(customerDto.getLastName());
        customer.setPhoneNumber(customerDto.getPhoneNumber());
        customer.setEmailAddress(customerDto.getEmailAddress());
        customer.setCreatedDate(customerDto.getCreatedDate());
        customer.setLastModifiedDate(customerDto.getLastModifiedDate());
        return customer;
    }

    private CustomerDto mapToDto(Customer customer) {
        // Map from entity to DTO
        CustomerDto customerDto = new CustomerDto();
        customerDto.setId(customer.getId());
        customerDto.setFirstName(customer.getFirstName());
        customerDto.setLastName(customer.getLastName());
        customerDto.setPhoneNumber(customer.getPhoneNumber());
        customerDto.setEmailAddress(customer.getEmailAddress());
        customerDto.setCreatedDate(customer.getCreatedDate());
        customerDto.setLastModifiedDate(customer.getLastModifiedDate());
        return customerDto;
    }
}
