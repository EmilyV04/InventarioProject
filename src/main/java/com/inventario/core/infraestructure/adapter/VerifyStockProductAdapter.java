package com.inventario.core.infraestructure.adapter;

import com.inventario.core.domain.servicie.VerifyStockProductService;
import com.inventario.core.infraestructure.repository.ProductRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
@Slf4j
public class VerifyStockProductAdapter implements VerifyStockProductService {
    private final ProductRepository productRepository;
    public boolean verifyStockProduct(Integer idProduct, Integer amount){
        log.info("Verificando stock el producto...");
        var productStockActual = productRepository.getById(idProduct);

        if(productStockActual.getStock() >= amount )
            return true;
        else
            return false;
    }
}
