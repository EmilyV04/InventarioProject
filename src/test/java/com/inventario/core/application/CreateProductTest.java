package com.inventario.core.application;

import com.inventario.core.domain.entities.Product;
import com.inventario.core.domain.servicie.CreateProductService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
class CreateProductTest {
    @InjectMocks
    private CreateProduct createProduct;
    @Mock
    private CreateProductService createProductService;

    @Test
    void createProduct(){
        var build = buildProduct();
        var response = buildProduct();
        Mockito.when(createProductService.createProduct(build)).thenReturn(response);
        createProduct.createProduct(build);
        Mockito.verify(createProductService, Mockito.times(1)).createProduct(build);
    }

    private Product buildProduct(){
        return Product.builder().id(2)
                .name("Set de carros")
                .purchaseCost(6500.0)
                .sellPrice(9000.0)
                .stock(20)
                .size(20)
                .idStore(1)
                .typeIdStore("NIT")
                .idCategory(2).build();
    }

}