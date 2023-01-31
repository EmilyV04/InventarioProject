package com.inventario.core.infraestructure.api.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.inventario.core.application.CreateProduct;
import com.inventario.core.infraestructure.api.mapper.ProductRequestMapper;
import com.inventario.core.infraestructure.api.request.CategoryRequest;
import com.inventario.core.infraestructure.api.request.ProductRequest;
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
@WebMvcTest(CreateProductController.class)
class CreateProductControllerTest {
    @Autowired
    private MockMvc mvc;
    @MockBean
    private CreateProduct createProduct;
    @MockBean
    private ProductRequestMapper productRequestMapper;

    @BeforeEach
    void setUp() {
    }

    @Test
    void createProduct() throws Exception {
        var content = buildContent();
        mvc.perform(MockMvcRequestBuilders.post("/product/createProduct").accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(content))
                .andDo(print())
                .andExpect(status().isOk());
    }

    private String buildContent() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(
                ProductRequest.builder().id(1)
                        .name("Frutiño")
                        .purchaseCost(500.0)
                        .sellPrice(800.0)
                        .stock(60)
                        .size(10)
                        .idStore(1)
                        .idCategory(1).build()
        );
    }
}