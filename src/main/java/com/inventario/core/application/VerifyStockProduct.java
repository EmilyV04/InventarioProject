package com.inventario.core.application;

import com.inventario.core.domain.servicie.VerifyStockProductService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class VerifyStockProduct {
    private final VerifyStockProductService verifyStockProductService;
    public void verifyProductStock(Integer idProduct, Integer amount){
        verifyStockProductService.verifyStockProduct(idProduct, amount);
    }
}
