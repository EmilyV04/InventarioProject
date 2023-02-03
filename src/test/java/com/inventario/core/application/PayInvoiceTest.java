package com.inventario.core.application;

import com.inventario.core.domain.servicie.PayInvoiceService;
import com.inventario.core.domain.servicie.SubtractProductStockService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class PayInvoiceTest {
    @InjectMocks
    private PayInvoice payInvoice;
    @Mock
    private PayInvoiceService payInvoiceService;
    @Mock
    private SubtractProductStockService subtractProductStockService;

    @Test
    void payInvoice() {
        payInvoice.payInvoice(1);
        Mockito.verify(subtractProductStockService, Mockito.times(1)).subtractProductStock(1);
        Mockito.verify(payInvoiceService, Mockito.times(1)).payInvoice(1);
    }
}