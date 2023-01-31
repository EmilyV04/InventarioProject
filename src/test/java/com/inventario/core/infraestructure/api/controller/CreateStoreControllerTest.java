package com.inventario.core.infraestructure.api.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.inventario.core.application.CreateStore;
import com.inventario.core.infraestructure.api.mapper.StoreRequestMapper;
import com.inventario.core.infraestructure.api.request.StoreRequest;
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
@WebMvcTest(CreateStoreController.class)
class CreateStoreControllerTest {

    @Autowired
    private MockMvc mvc;
    @MockBean
    private CreateStore createStore;
    @MockBean
    private StoreRequestMapper storeRequestMapper;

    @BeforeEach
    void setUp(){
    }

    @Test
    void createStore() throws Exception{
        var content = buildContent();
        mvc.perform(MockMvcRequestBuilders.post("/store/createStore").accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .content(content))
                .andDo(print())
                .andExpect(status().isOk());
    }

    private String buildContent() throws JsonProcessingException{
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(
                StoreRequest.builder().id(1)
                        .typeId("NIT")
                        .name("XYZ STORE")
                        .idCountry(123)
                        .idMunicipality(321)
                        .address("mz 47 lt 12").build());
    }
}