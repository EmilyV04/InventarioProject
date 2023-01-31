package com.inventario.core.application;

import com.inventario.core.domain.entities.Product;
import com.inventario.core.domain.servicie.CreateProductService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CreateProduct {
    private final CreateProductService createProductService;
    public void createProduct(Product product){
        createProductService.createProduct(product);
    }
}
