package com.inventario.core.infraestructure.adapter;

import com.inventario.core.domain.entities.Product;
import com.inventario.core.domain.servicie.DeleteProductService;
import com.inventario.core.infraestructure.mapper.ProductMapper;
import com.inventario.core.infraestructure.repository.ProductRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
@Slf4j
public class DeleteProductAdapter implements DeleteProductService {
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;
    public void deleteProduct(Integer idProduct){
        log.info("Eliminando producto...");
        productRepository.deleteById(idProduct);
    }
}
