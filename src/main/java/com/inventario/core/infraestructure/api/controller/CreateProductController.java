package com.inventario.core.infraestructure.api.controller;

import com.inventario.core.application.CreateProduct;
import com.inventario.core.infraestructure.api.mapper.ProductRequestMapper;
import com.inventario.core.infraestructure.api.request.ProductRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("product")
@RequiredArgsConstructor
public class CreateProductController {
    private final CreateProduct createProduct;
    private final ProductRequestMapper productRequestMapper;

    @PostMapping(value = "/createProduct")
    public void CreateProduct(@RequestBody ProductRequest productRequest){
        createProduct.createProduct(productRequestMapper.toEntity(productRequest));
    }
}
