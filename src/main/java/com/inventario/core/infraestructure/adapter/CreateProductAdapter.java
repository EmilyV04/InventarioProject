package com.inventario.core.infraestructure.adapter;

import com.inventario.core.domain.entities.Product;
import com.inventario.core.domain.servicie.CreateProductService;
import com.inventario.core.infraestructure.dto.compositekeys.KeyStoreDto;
import com.inventario.core.infraestructure.mapper.ProductMapper;
import com.inventario.core.infraestructure.repository.CategoryRepository;
import com.inventario.core.infraestructure.repository.ProductRepository;
import com.inventario.core.infraestructure.repository.StoreRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
@Slf4j
public class CreateProductAdapter implements CreateProductService {
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;
    private final StoreRepository storeRepository;
    private final CategoryRepository categoryRepository;
    @Override
    public Product createProduct(Product product) {
        log.info("Aquí comenzamos a guardar un producto!");
        var keyStore = KeyStoreDto.builder().id(product.getIdStore()).typeId(product.getTypeIdStore()).build();
        var store = storeRepository.findById(keyStore);
        var category = categoryRepository.findById(product.getIdCategory());

        if(store.isEmpty() || category.isEmpty()){
            //TODO REALIZAR MANEJO DE EXCEPCIONES
            throw new RuntimeException();
        }

        var productEntity = productMapper.toDto(product);
        productEntity.setCategory(category.get());
        productEntity.setStore(store.get());
        return productMapper.toEntity(productRepository.save(productEntity));
    }
}
