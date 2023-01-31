package com.inventario.core.infraestructure.adapter;

import com.inventario.core.domain.entities.Invoice;
import com.inventario.core.domain.entities.Product;
import com.inventario.core.domain.servicie.FindInvoiceService;
import com.inventario.core.domain.servicie.FindProductService;
import com.inventario.core.infraestructure.mapper.InvoiceMapper;
import com.inventario.core.infraestructure.mapper.ProductMapper;
import com.inventario.core.infraestructure.repository.InvoiceRepository;
import com.inventario.core.infraestructure.repository.ProductRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
@Slf4j
public class FindProductAdapter implements FindProductService {
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;
    @Override
    public Product findProduct(Integer idProduct) {
        var product = productRepository.findById(idProduct);
        if (product.isEmpty()){
            throw new RuntimeException();
        }
        return productMapper.toEntity(product.get());
    }
}
