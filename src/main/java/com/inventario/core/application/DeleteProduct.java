package com.inventario.core.application;

import com.inventario.core.domain.entities.Product;
import com.inventario.core.domain.servicie.DeleteProductService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class DeleteProduct {
    private final DeleteProductService deleteProductService;
    public void deleteProduct(Integer idProduct){
        deleteProductService.deleteProduct(idProduct);
    }
}
