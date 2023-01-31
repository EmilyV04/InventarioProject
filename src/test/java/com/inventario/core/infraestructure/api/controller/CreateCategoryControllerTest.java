package com.inventario.core.infraestructure.api.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.inventario.core.application.CreateCategory;
import com.inventario.core.infraestructure.api.mapper.CategoryRequestMapper;
import com.inventario.core.infraestructure.api.request.CategoryRequest;
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

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
@ExtendWith(SpringExtension.class)
@WebMvcTest(CreateCategoryController.class)
class CreateCategoryControllerTest {

    @Autowired
    private MockMvc mvc;
    @MockBean
    private CreateCategory createCategory;
    @MockBean
    private CategoryRequestMapper categoryRequestMapper;

    @BeforeEach
    void setUp() {
    }

    @Test
    void createCategory() throws Exception {
        var content = buildContent();
        mvc.perform(MockMvcRequestBuilders.post("/category/createCategory").accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .content(content))
                .andDo(print())
                .andExpect(status().isOk());
    }

    private String buildContent() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(CategoryRequest.builder().id(1).name("Bebidas").sizeUnit("ml").build());
    }
}