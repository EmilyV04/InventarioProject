package com.inventario.core.domain.servicie;

public interface VerifyStockProductService {
    boolean verifyStockProduct(Integer idProduct, Integer amount);
}
