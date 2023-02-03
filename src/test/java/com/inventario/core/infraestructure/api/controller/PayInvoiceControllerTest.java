package com.inventario.core.infraestructure.api.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.inventario.core.application.PayInvoice;
import com.inventario.core.infraestructure.api.mapper.InvoiceRequestMapper;
import com.inventario.core.infraestructure.api.request.CategoryRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(PayInvoiceController.class)
class PayInvoiceControllerTest {
    @Autowired
    private MockMvc mvc;
    @MockBean
    private PayInvoice payInvoice;
    @MockBean
    private InvoiceRequestMapper invoiceRequestMapper;

    @BeforeEach
    void setUp() {
    }

    @Test
    void payInvoice() throws Exception {
        mvc.perform(MockMvcRequestBuilders.put("/invoice/payInvoice/{invoiceNumber}",1))
                .andDo(print())
                .andExpect(status().isOk());
    }
}