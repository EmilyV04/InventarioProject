package com.inventario.core.infraestructure.api.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.inventario.core.application.InvoiceProduct;
import com.inventario.core.infraestructure.api.mapper.InvoiceDetailRequestMapper;
import com.inventario.core.infraestructure.api.request.CategoryRequest;
import com.inventario.core.infraestructure.api.request.InvoiceDetailRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(InvoiceProductController.class)
class InvoiceProductControllerTest {
    @Autowired
    private MockMvc mvc;
    @MockBean
    private InvoiceProduct invoiceProduct;
    @MockBean
    private InvoiceDetailRequestMapper invoiceDetailRequestMapper;

    @BeforeEach
    void setUp() {
    }

    @Test
    void invoiceProduct() throws Exception {
        var content = buildContent();
        mvc.perform(MockMvcRequestBuilders.post("/product/invoiceProduct").accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(content))
                .andDo(print())
                .andExpect(status().isOk());
    }

    private String buildContent() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();

        return objectMapper.writeValueAsString(
                List.of(buildInvoiceDetailRequest())
        );
    }

    private static InvoiceDetailRequest buildInvoiceDetailRequest() {
        return InvoiceDetailRequest.builder().id(1)
                .amount(5)
                .iva(19.0)
                .idProduct(1)
                .invoiceNumber(1).build();
    }
}