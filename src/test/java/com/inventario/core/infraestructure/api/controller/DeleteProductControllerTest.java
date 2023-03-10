package com.inventario.core.infraestructure.api.controller;

import com.inventario.core.application.DeleteProduct;
import com.inventario.core.infraestructure.api.mapper.ProductRequestMapper;
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
@WebMvcTest(DeleteProductController.class)
class DeleteProductControllerTest {
    @Autowired
    private MockMvc mvc;
    @MockBean
    private DeleteProduct deleteProduct;
    @MockBean
    private ProductRequestMapper productRequestMapper;

    @BeforeEach
    void setUp() {
    }

    @Test
    void deleteProduct() throws Exception {
        //var content = buildContent();
        mvc.perform(MockMvcRequestBuilders.delete("/product/deleteProduct/{idProduct}",1))
                .andDo(print())
                .andExpect(status().isOk());
    }
}