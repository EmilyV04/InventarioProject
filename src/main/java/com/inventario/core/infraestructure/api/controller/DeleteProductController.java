package com.inventario.core.infraestructure.api.controller;

import com.inventario.core.application.DeleteProduct;
import com.inventario.core.infraestructure.api.mapper.ProductRequestMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("product")
@RequiredArgsConstructor
public class DeleteProductController {
    private final DeleteProduct deleteProduct;
    private final ProductRequestMapper productRequestMapper;
    @DeleteMapping(value = "/deleteProduct/{idProduct}")
    public void DeleteProduct(@PathVariable("idProduct") Integer idProduct){
        deleteProduct.deleteProduct(idProduct);
    }
}
