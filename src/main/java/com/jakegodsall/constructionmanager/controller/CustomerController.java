package com.jakegodsall.constructionmanager.controller;

import com.jakegodsall.constructionmanager.entity.Customer;
import com.jakegodsall.constructionmanager.payload.CustomerDto;
import com.jakegodsall.constructionmanager.service.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(path = "/api/customers")
public class CustomerController {

    private CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    public ResponseEntity<List<CustomerDto>> getAllCustomers() {
        // Get List of Customer DTOs
        List<CustomerDto> customers = customerService.getAllCustomers();
        // Return HTTP response with List of Customer DTOs in body with 200 status code
        return new ResponseEntity<>(customers, HttpStatus.OK);
    }

    @PostMapping
    ResponseEntity<CustomerDto> createCustomer(@RequestBody CustomerDto customerDto) {
        System.out.println("FROM POST MAPPING");
        System.out.println(customerDto);
        // Create the entity in the db
        CustomerDto customer = customerService.createCustomer(customerDto);
        // Construct the URI for the entity
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(customer.getId())
                .toUri();
        // Return HTTP response with Location Header of newly created row in db and DTO in body (status 301)
        return ResponseEntity
                .created(location)
                .body(customer);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerDto> getCustomerById(@PathVariable Long id) {
        // Get Customer DTO object
        CustomerDto customer = customerService.getCustomerById(id);
        // Return HTTP response with Customer DTO in body and status code 200
        return new ResponseEntity<>(customer, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CustomerDto> updateCustomerById(
            @RequestBody CustomerDto customerDto,
            @PathVariable Long id
    ) {
        // Update the value in the database with values from DTO provided in request body
        CustomerDto customer = customerService.updateCustomer(customerDto, id);
        // Return HTTP response with updated customer DTO and status code 200
        return new ResponseEntity<>(customer, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCustomerById(@PathVariable Long id) {
        // Delete the row in db with primary key provided in path
        customerService.deleteCustomer(id);
        // Return a HTTP response with empty body and status code 204
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
