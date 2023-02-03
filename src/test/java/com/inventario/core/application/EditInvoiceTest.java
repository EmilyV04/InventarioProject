package com.inventario.core.application;

import com.inventario.core.domain.entities.Invoice;
import com.inventario.core.domain.servicie.EditInvoiceService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
class EditInvoiceTest {
    @InjectMocks
    private EditInvoice editInvoice;
    @Mock
    private EditInvoiceService editInvoiceService;

    @Test
    void editInvoice() {
        var invoice = buildInvoice();
        editInvoice.editInvoice(invoice);
        Mockito.verify(editInvoiceService,Mockito.times(1)).editInvoice(invoice);
    }

    private Invoice buildInvoice() {
        return Invoice.builder().invoiceNumber(1)
                .description("Factura 001")
                .idClient(1)
                .typeIdClient("CC").build();
    }
}