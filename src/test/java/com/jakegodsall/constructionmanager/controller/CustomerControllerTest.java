package com.jakegodsall.constructionmanager.controller;

import com.jakegodsall.constructionmanager.repository.CustomerRepository;
import com.jakegodsall.constructionmanager.service.CustomerService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(CustomerController.class)
class CustomerControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    CustomerService customerService;

    // Success Path Tests

    @Test
    public void testGetReturns200Response() throws Exception {
        mockMvc.perform(get(CustomerController.API_V1_ENDPOINT))
                .andExpect(status().isOk());
    }

    @Test
    public void shouldReturnAllItems() throws Exception {
        mockMvc.perform(get(CustomerController.API_V1_ENDPOINT))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$").isArray());
    }

    @Test
    public void shouldReturnEmptyListWhenNoItemsPresent() throws Exception {
        mockMvc.perform(get(CustomerController.API_V1_ENDPOINT))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(0)));
    }

}