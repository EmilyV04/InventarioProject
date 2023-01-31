package com.inventario.core.application;

import com.inventario.core.domain.servicie.DeleteProductService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
class DeleteProductTest {
    @InjectMocks
    private DeleteProduct deleteProduct;
    @Mock
    private DeleteProductService deleteProductService;

    @Test
    void deleteProduct() {
        deleteProduct.deleteProduct(1);
        Mockito.verify(deleteProductService, Mockito.times(1)).deleteProduct(1);
    }
}