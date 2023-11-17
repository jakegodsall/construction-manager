package com.jakegodsall.constructionmanager.mapper;

import com.jakegodsall.constructionmanager.entity.Customer;
import com.jakegodsall.constructionmanager.payload.CustomerDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CustomerMapper {
    Customer customerDtoToCustomer(CustomerDto customerDto);
    CustomerDto customerToCustomerDto(Customer customer);
}
