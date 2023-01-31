package com.inventario.core.infraestructure.api.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.inventario.core.application.CreateInvoice;
import com.inventario.core.infraestructure.api.mapper.InvoiceRequestMapper;
import com.inventario.core.infraestructure.api.request.CategoryRequest;
import com.inventario.core.infraestructure.api.request.InvoiceRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(CreateInvoiceController.class)
class CreateInvoiceControllerTest {
    @Autowired
    private MockMvc mvc;
    @MockBean
    private CreateInvoice createInvoice;
    @MockBean
    private InvoiceRequestMapper invoiceRequestMapper;

    @BeforeEach
    void setUp() {
    }

    @Test
    void createInvoice() throws Exception {
        var content = buildContent();
        mvc.perform(MockMvcRequestBuilders.post("/invoice/createInvoice").accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(content))
                .andDo(print())
                .andExpect(status().isOk());
    }

    private String buildContent() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(
                InvoiceRequest.builder().invoiceNumber(1)
                        .description("Factura XYZ")
                        .idClient(1)
                        .typeIdClient("CC").build());
    }
}