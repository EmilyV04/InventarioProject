package com.inventario.core.infraestructure.api.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.inventario.core.application.CreateClient;
import com.inventario.core.infraestructure.api.mapper.ClientRequestMapper;
import com.inventario.core.infraestructure.api.request.ClientRequest;
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
@WebMvcTest(CreateClientController.class)
class CreateClientControllerTest {
    @Autowired
    private MockMvc mvc;
    @MockBean
    private CreateClient createClient;
    @MockBean
    private ClientRequestMapper clientRequestMapper;

    @BeforeEach
    void setUp(){
    }

    @Test
    void createClient() throws Exception{
        var content = buildContent();
        mvc.perform(MockMvcRequestBuilders.post("/client/createClient").accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .content(content))
                .andDo(print())
                .andExpect(status().isOk());
    }

    private String buildContent() throws JsonProcessingException{
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(
                ClientRequest.builder().id(1)
                        .typeId("CC")
                        .names("David")
                        .lastNames("Martinez")
                        .phoneNumber(1236547)
                        .cellphoneNumber(147852369).build()
        );
    }
}