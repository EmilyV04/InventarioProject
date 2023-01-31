package com.inventario.core.application;

import com.inventario.core.domain.entities.Invoice;
import com.inventario.core.domain.servicie.CreateInvoiceService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CreateInvoice {
    private final CreateInvoiceService createInvoiceService;
    public void createInvoice(Invoice invoice){
        createInvoiceService.createInvoice(invoice);
    }
}
