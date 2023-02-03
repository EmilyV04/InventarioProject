package com.inventario.core.application;

import com.inventario.core.domain.servicie.VerifyStockProductService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class VerifyStockProductTest {
    @InjectMocks
    private VerifyStockProduct verifyStockProduct;
    @Mock
    private VerifyStockProductService verifyStockProductService;

    @Test
    void verifyProductStock() {
        Mockito.when(verifyStockProductService.verifyStockProduct(4,20)).thenReturn(Boolean.TRUE);
        verifyStockProduct.verifyProductStock(4,20);
        Mockito.verify(verifyStockProductService,Mockito.times(1)).verifyStockProduct(4,20);
    }
}