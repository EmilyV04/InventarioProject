package com.inventario.core.application;

import com.inventario.core.domain.entities.Invoice;
import com.inventario.core.domain.servicie.CreateInvoiceService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
class CreateInvoiceTest {
    @InjectMocks
    private CreateInvoice createInvoice;
    @Mock
    private CreateInvoiceService createInvoiceService;

    @Test
    void createInvoice() {
        var build = buildInvoice();
        var response = buildInvoice();
        Mockito.when(createInvoiceService.createInvoice(build)).thenReturn(response);
        createInvoice.createInvoice(build);
        Mockito.verify(createInvoiceService,Mockito.times(1)).createInvoice(build);
    }

    private Invoice buildInvoice(){
        return Invoice.builder().invoiceNumber(4)
                .description("Factura 004")
                .idClient(1)
                .typeIdClient("CC").build();
    }
}