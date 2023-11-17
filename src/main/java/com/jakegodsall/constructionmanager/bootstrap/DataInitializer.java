package com.jakegodsall.constructionmanager.bootstrap;

import com.jakegodsall.constructionmanager.entity.Address;
import com.jakegodsall.constructionmanager.entity.Customer;
import com.jakegodsall.constructionmanager.payload.AddressDto;
import com.jakegodsall.constructionmanager.payload.CustomerDto;
import com.jakegodsall.constructionmanager.payload.JobDto;
import com.jakegodsall.constructionmanager.service.CustomerService;
import com.jakegodsall.constructionmanager.service.JobService;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
@AllArgsConstructor
public class DataInitializer implements CommandLineRunner {

    private final CustomerService customerService;
    private final JobService jobService;

    @Override
    public void run(String... args) throws Exception {
        initializeCustomers();
        initializeJobs();
    }

    private void initializeCustomers() {
        CustomerDto customer1 = CustomerDto.builder()
                .firstName("John")
                .lastName("Doe")
                .phoneNumber("+44 7368425604")
                .emailAddress("john.doe@mail.com")
                .build();

        CustomerDto customer2 = CustomerDto.builder()
                .firstName("Jane")
                .lastName("Doe")
                .phoneNumber("+44 123456789")
                .emailAddress("jane.doe@mail.com")
                .build();

        customerService.createCustomer(customer1);
        customerService.createCustomer(customer2);
    }

    private void initializeJobs() {
        JobDto job1 = JobDto.builder()
                .addressDto(AddressDto.builder()
                        .street("25 Camden Street")
                        .city("Walsall")
                        .postcode("WS9 9BQ")
                        .build())
                .price(new BigDecimal(1000))
                .build();

        System.out.println("JOB1" + job1);

        jobService.createJob(job1);
    }
}
